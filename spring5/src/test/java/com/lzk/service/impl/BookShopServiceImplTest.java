package com.lzk.service.impl;

import com.lzk.dao.BookShopDao;
import com.lzk.service.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookShopServiceImplTest {
    private ApplicationContext applicationContext = null;
    private BookShopService bookShopService;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        bookShopService = applicationContext.getBean(BookShopService.class);
    }
    @Test
    public void purchase() throws Exception {
        bookShopService.purchase("AA");
    }

}