package com.lzk.mapper;

import com.lzk.model.User;

/**
 * Created by lzk on 2018/2/10 21:37
 * Description:
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User queryById(String username);
}
