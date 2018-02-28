package com.lzk.service.impl;

import com.lzk.mapper.UserMapper;
import com.lzk.model.User;
import com.lzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:19
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        if (user != null) {
            return userMapper.addUser(user);
        }
        return 0;
    }

    @Override
    public int updateUserByUserName(User user) {
        if (user != null) {
            return userMapper.updateUserByUserName(user);
        }
        return 0;
    }

    @Override
    public User getUserByUserName(String userName) {
        if (userName != null) {
            return userMapper.findUserByUserName(userName);
        }
        return null;
    }

    @Override
    public int deleteUserByUserName(String userName) {
        if (userName != null) {
            return userMapper.deleteUserByUserName(userName);
        }
        return 0;
    }

    @Override
    public int loginSuccess(User user) {
        //todo 这个方法是干嘛用的
        return 0;
    }

    @Override
    public String getPassword(String userName) {
        if (userName != null) {
            return userMapper.getUserPasswordByUserName(userName);
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUserInfo();
    }
}
