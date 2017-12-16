package com.lzk.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("lzk");
        helloWorld.hello();*/
        //1创建Spring的IOC容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //2从IOC容器中获取bean实例
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        //3调用bean方法
        helloWorld.hello();
        System.out.println("=========================");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
        car = (Car) applicationContext.getBean("car2");
        System.out.println(car);
        System.out.println("=========================");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        System.out.println("=========================");
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld2");
        helloWorld2.hello();
    }
}
