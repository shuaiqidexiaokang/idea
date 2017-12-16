package com.lzk.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-generic-di.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
}
