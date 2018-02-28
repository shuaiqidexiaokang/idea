package com.lzk.mapper;

import com.lzk.model.User;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void findUserByUserName() throws Exception {
        User user = userMapper.findUserByUserName("张三");
        System.out.println(user);
    }

    @Test
    public void findUserByUserId() throws Exception {
        User user = userMapper.findUserByUserId(1);
        System.out.println(user);
    }

    @Test
    public void addUser() throws Exception {
        User user = new User("aa","123456",132456,"123456748","0",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),"111");
        userMapper.addUser(user);
    }

    @Test
    public void deleteUserByUserName() throws Exception {
        userMapper.deleteUserByUserName("aa");
    }

    @Test
    public void updateUserByUserName() throws Exception {
        User user = new User("aa","4564564564465",22222,"123456748","0",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),"111");
        userMapper.updateUserByUserName(user);
    }

    @Test
    public void getUserPasswordByUserName() throws Exception {
        String password = userMapper.getUserPasswordByUserName("张三");
        System.out.println(password);
    }

    @Test
    public void getAllUserInfo() throws Exception {
        List<User> users =  userMapper.getAllUserInfo();
        users.forEach(System.out::println);
    }

}