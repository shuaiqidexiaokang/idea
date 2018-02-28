package com.lzk.service;

import com.lzk.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        User user = new User("bb","123456",132456,"123456748","0",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),"111");
        int result = userService.addUser(user);
        System.out.println(result);
    }

    @Test
    public void updateUserByUserName() throws Exception {
    }

    @Test
    public void getUserByUserName() throws Exception {
    }

    @Test
    public void deleteUserByUserName() throws Exception {
    }

    @Test
    public void loginSuccess() throws Exception {
    }

    @Test
    public void getPassword() throws Exception {
    }

    @Test
    public void getAllUser() throws Exception {
    }

}