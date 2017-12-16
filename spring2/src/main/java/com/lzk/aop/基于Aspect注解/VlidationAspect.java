package com.lzk.aop.基于Aspect注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)//设置切面优先级，数字越低，优先级越高
public class VlidationAspect {

    @Before("LoggingAspect.declareJoinPointExpression()")
    public void vlidationAspect(JoinPoint joinPoint){
        System.out.println("VlidationAspect " + Arrays.asList(joinPoint.getArgs()));
    }
}
