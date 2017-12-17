package com.lzk.hibernate.service.impl;

import com.lzk.hibernate.service.CashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class CashierServiceImplTest {
    private CashierService cashierService;
    private ApplicationContext applicationContext = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        cashierService = applicationContext.getBean(CashierService.class);
    }
    @Test
    public void checkout() throws Exception {
        cashierService.checkout("AA", Arrays.asList("1001","1002"));
    }

}