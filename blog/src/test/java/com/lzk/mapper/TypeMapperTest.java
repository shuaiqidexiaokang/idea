package com.lzk.mapper;

import com.lzk.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml"})
public class TypeMapperTest {
    @Autowired
    TypeMapper typeMapper;
    @Test
    public void queryAll() throws Exception {
        List<Type> types = typeMapper.queryAll();
        System.out.println(types);
    }

}