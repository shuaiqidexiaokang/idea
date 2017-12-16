package com.lzk.factorybean;

import com.lzk.factorybean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-beanfactory.xml");
        Car car = (Car) applicationContext.getBean("carFactory");
        System.out.println(car);
    }
}
