package com.lzk.dao;

import com.lzk.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {

    }

    @Test
    public void queryById() throws Exception {
        long seckillId = 1001;
        Seckill seckill =  seckillDao.queryById(seckillId);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
    }

}