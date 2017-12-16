package com.lzk.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-cycle.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
        applicationContext.close();

    }
}
