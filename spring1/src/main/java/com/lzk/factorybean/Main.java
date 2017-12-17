package com.lzk.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-factorybean.xml");
        Car car = (Car) applicationContext.getBean("carFactory");
        System.out.println(car);
    }
}
