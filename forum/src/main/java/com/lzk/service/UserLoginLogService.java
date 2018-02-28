package com.lzk.service;

import com.lzk.model.UserLoginLog;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:17
 * Description:
 */
public interface UserLoginLogService {
    public List<UserLoginLog> listAllUserLoginLog();

    public int addUserLoginLog(UserLoginLog userLoginLog);
}
