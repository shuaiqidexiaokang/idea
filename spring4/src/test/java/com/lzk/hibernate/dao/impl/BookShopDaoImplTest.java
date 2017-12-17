package com.lzk.hibernate.dao.impl;

import com.lzk.hibernate.dao.BookShopDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class BookShopDaoImplTest {
    private BookShopDao bookShopDao;
    private ApplicationContext applicationContext = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        bookShopDao = (BookShopDao) applicationContext.getBean("bookShopDao");
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