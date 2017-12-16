package com.lzk.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringTransactionTest {

    private ApplicationContext applicationContext = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        bookShopDao = (BookShopDao) applicationContext.getBean("bookShopDao");
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }

    @Test
    public void testCheckout(){
       cashier.checkout("AA", Arrays.asList("1001","1002"));
    }

    @Test
    public void testPurchase(){
        bookShopService.purchase("AA","1001");
    }

    @Test
    public void testFindBookPriceByIsbn(){
        double price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println(price);
    }

    @Test
    public void testUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);
    }
}
