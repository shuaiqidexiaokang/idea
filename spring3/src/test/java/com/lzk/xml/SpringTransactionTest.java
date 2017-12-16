package com.lzk.xml;

import com.lzk.xml.service.BookShopService;
import com.lzk.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {

    private ApplicationContext applicationContext = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
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
}
