package com.lzk.aop.基于xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) applicationContext.getBean(ArithmeticCalculator.class);
        int result = arithmeticCalculator.add(1,1);
        System.out.println(result);
        result = arithmeticCalculator.div(3,1);
        System.out.println(result);
    }
}
