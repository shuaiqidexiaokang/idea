package com.lzk.service;

import com.lzk.model.User;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:17
 * Description:
 */
public interface UserService {
    public int addUser(User user);

    public int updateUserByUserName(User user);

    public User getUserByUserName(String userName);

    public int deleteUserByUserName(String userName);

    public int loginSuccess(User user);

    public String getPassword(String userName);

    public List<User> getAllUser();
}
