package com.lzk.mapper;

import com.lzk.model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findUserByUserName(String username);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User findUserByUserId(int id);

    /**
     * 添加用户信息（用户名，密码，电话，email，性别，创建时间，最后一次登录时间，登录ip）
     * @param user
     */
    public int addUser(User user);

    /**
     * 根据用户名删除用户信息
     * @param username
     */
    public int deleteUserByUserName(String username);

    /**
     * 根据用户名修改用户信息(密码，电话，email，性别，创建时间，积分，最后一次登录时间，登录ip)
     * @param user
     */
    public int updateUserByUserName(User user);

    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    public String getUserPasswordByUserName(String username);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> getAllUserInfo();
}
