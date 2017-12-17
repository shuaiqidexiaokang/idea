package com.lzk.dao.impl;

import com.lzk.dao.BookShopDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class BookShopDaoImplTest {
    private ApplicationContext applicationContext = null;
    private BookShopDao bookShopDao;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        bookShopDao = applicationContext.getBean(BookShopDao.class);
    }
    @Test
    public void findBookPriceByIsbn() throws Exception {
        double price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println(price);
    }

    @Test
    public void updateBookStock() throws Exception {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void updateUserAccount() throws Exception {
        bookShopDao.updateUserAccount("AA",100);
    }

}