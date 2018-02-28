package com.lzk.controller;

import com.lzk.model.User;
import com.lzk.model.UserLoginLog;
import com.lzk.service.UserLoginLogService;
import com.lzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by lzk on 2018/2/22 17:48
 * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserLoginLogService userLoginLogService;

    //用户登录
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(User loginUser, HttpServletRequest request) {
        //根据用户名查找User对象
        User user = userService.getUserByUserName(loginUser.getUserName());
        System.out.println(user);
        System.out.println(loginUser);
        String password = "";
        if (user != null) {
            password = userService.getPassword(loginUser.getUserName());
        }
        if (user != null && loginUser.getPassword().equals(password)) {
            //获取基本数据
            String userName = user.getUserName();
            String lastIP = request.getRemoteAddr();
            Timestamp lastLoginTime = new Timestamp(new Date().getTime());

            //更新用户信息
            user.setLastIp(lastIP);
            user.setLastLoginTime(lastLoginTime);
            user.setCredit(5 + user.getCredit());
            userService.updateUserByUserName(user);

            // 更新用户登录日志
            UserLoginLog userLoginLog = new UserLoginLog(userName, lastIP, lastLoginTime);
            userLoginLogService.addUserLoginLog(userLoginLog);

            // 登陆成功，重定向到主页
            request.getSession().setAttribute("username", user.getUserName());
            return "redirect:/main";
        }

        // 登录失败，转发页面
        request.setAttribute("Msg", "登录失败");
        return "error";
    }

    // 用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(User userRegister, HttpServletRequest request) {
        System.out.println(userRegister);
        User user = userRegister;
        if (user != null) {
            try {
                String username = user.getUserName();
                String ip = request.getRemoteAddr();

                // 如果数据库中没有该用户，可以注册，否则跳转页面
                if (userService.getUserByUserName(username) == null) {

                    // 添加用户
                    user.setLastIp(ip);
                    Timestamp createLoginTime = new Timestamp(new Date().getTime());
                    user.setCreateTime(createLoginTime);
                    user.setLastLoginTime(createLoginTime);
                    userService.addUser(user);

                    // 添加用户登录日志
                    UserLoginLog userLoginLog = new UserLoginLog();
                    userLoginLog.setUserName(username);
                    userLoginLog.setLoginIp(ip);
                    userLoginLog.setLoginDateTime(createLoginTime);
                    userLoginLogService.addUserLoginLog(userLoginLog);

                    // 注册成功跳转
                    request.setAttribute("username", username);
                    return "index";
                } else {
                    request.setAttribute("Msg", "注册失败，用户名已被占用！");
                    return "error";
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("Msg", "发生未知错误！");
                return "error";
            }
        }
        request.setAttribute("Msg", "发生未知错误！");
        return "error";
    }

    // 显示个人信息
    @RequestMapping(value = "/listUserInfo")
    public String listUserInfo(@RequestParam("username") String username, HttpServletRequest request) {
        User user = userService.getUserByUserName(username);
        request.setAttribute("user", user);
        return "user/userInfo";
    }

    // 修改个人信息页面
    @RequestMapping(value = "/userUpdateInfo", method = RequestMethod.GET)
    public String userUpdateInfoPage(String username, HttpServletRequest request) {
        User user = userService.getUserByUserName(username);
        request.setAttribute("user", user);
        return "user/userUpdateInfo";
    }

    // 提交用户修改信息
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(User user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        User newUser = user;
        userService.updateUserByUserName(newUser);
        redirectAttributes.addAttribute("username", newUser.getUserName());
        return "redirect:listUserInfo";
    }

    // 用户注销功能
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "index";
    }

}
