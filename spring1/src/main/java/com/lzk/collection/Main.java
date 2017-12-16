package com.lzk.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-collection.xml");
        PersonListCar personListCar = (PersonListCar) applicationContext.getBean("personListCar");
        System.out.println(personListCar);
        PersonListCar personListCar1 = (PersonListCar) applicationContext.getBean("personListCar1");
        System.out.println(personListCar1);
        PersonMapCar personMapCar = (PersonMapCar) applicationContext.getBean("personMapCar");
        System.out.println(personMapCar);
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }
}
