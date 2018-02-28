package com.lzk.mapper;

import com.lzk.model.UserLoginLog;

import java.util.List;

public interface UserLoginLogMapper {
    /**
     * 查询用户登录日志信息
     * @return
     */
    public List<UserLoginLog> listAllUserLoginLog();

    /**
     * 添加用户登录日志信息（登录用户名，登录ip，登录时间）
     * @param userLoginLog
     */
    public int addUserLoginLog(UserLoginLog userLoginLog);
}
