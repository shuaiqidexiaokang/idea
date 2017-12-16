package com.lzk.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization" + o + ":" + s);
        if (s.equals("car")){
            return o;
        }
        return null;

    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization" + o + ":" + s);
        Car car = new Car();
        car.setBrand("Ford");
        return car;
    }
}
