package com.lzk.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-spel.xml");

        Address address = (Address) applicationContext.getBean("address");
        System.out.println(address);
        System.out.println("-------------------------");

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
        System.out.println("-------------------------");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
