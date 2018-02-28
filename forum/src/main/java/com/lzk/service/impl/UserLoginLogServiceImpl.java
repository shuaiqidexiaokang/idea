package com.lzk.service.impl;

import com.lzk.mapper.UserLoginLogMapper;
import com.lzk.model.UserLoginLog;
import com.lzk.service.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/2/17 19:25
 * Description:
 */
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public List<UserLoginLog> listAllUserLoginLog() {
        return userLoginLogMapper.listAllUserLoginLog();
    }

    @Override
    public int addUserLoginLog(UserLoginLog userLoginLog) {
        if (userLoginLog != null) {
            return userLoginLogMapper.addUserLoginLog(userLoginLog);
        }
        return 0;
    }
}
