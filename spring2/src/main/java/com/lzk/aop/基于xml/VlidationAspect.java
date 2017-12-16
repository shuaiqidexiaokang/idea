package com.lzk.aop.基于xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class VlidationAspect {

    public void vlidationAspect(JoinPoint joinPoint){
        System.out.println("VlidationAspect " + Arrays.asList(joinPoint.getArgs()));
    }
}
