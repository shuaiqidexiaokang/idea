package com.lzk.mapper;

import com.lzk.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml"})
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void queryById() throws Exception {
        String username = "admin";
        User user = userMapper.queryById(username);
        System.out.println(user);
    }

}