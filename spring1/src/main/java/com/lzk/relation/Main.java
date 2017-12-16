package com.lzk.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-relation.xml");
        /*Address address1 = (Address) applicationContext.getBean("address1");
        System.out.println(address1);*/
        Address address2 = (Address) applicationContext.getBean("address2");
        System.out.println(address2);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
