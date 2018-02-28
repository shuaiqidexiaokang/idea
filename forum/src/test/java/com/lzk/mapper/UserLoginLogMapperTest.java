package com.lzk.mapper;

import com.lzk.model.UserLoginLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class UserLoginLogMapperTest {
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;
    @Test
    public void listAllUserLoginLog() throws Exception {
        List<UserLoginLog> userLoginLogs = userLoginLogMapper.listAllUserLoginLog();
        userLoginLogs.forEach(System.out::println);
    }

    @Test
    public void addUserLoginLog() throws Exception {
        UserLoginLog userLoginLog = new UserLoginLog("张三","13245646",new Timestamp(new Date().getTime()));
        userLoginLogMapper.addUserLoginLog(userLoginLog);
    }

}