package com.lzk.hibernate.service.impl;

import com.lzk.hibernate.service.BookShopService;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookShopServiceImplTest {
    private BookShopService bookShopService;
    private ApplicationContext applicationContext = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        bookShopService = applicationContext.getBean(BookShopService.class);
    }

    @Test
    public void purchase() throws Exception {
        bookShopService.purchase("AA","1001");
    }

}