package com.lzk.scope;

import com.lzk.scope.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-scope.xml");
        Car car = (Car) applicationContext.getBean("car");
        Car car2 = (Car) applicationContext.getBean("car");
        System.out.println(car == car2);
    }
}
