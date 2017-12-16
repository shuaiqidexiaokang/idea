package com.lzk.aop.基于Aspect注解;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//把这个类声明为一个切面：需要把这个类放入到IOC容器、在声明为一个切面
@Component
@Aspect
@Order(2)
public class LoggingAspect {

    //定义一个方法，用于声明切入点表达式，一般该方法不需要添加其他的代码
    //使用@Pointcut来声明切入点表达式
    //后面的其他通知直接使用方法名来饮用当前的切入点表达式
    @Pointcut("execution(public int com.lzk.aop.基于Aspect注解.ArithmeticCalculator.*(int,int))")
    public void declareJoinPointExpression(){}

    //该方法是前置通知：在目标方法之前执行
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    //该方法是后置通知：在目标方法后执行（无论是否发生异常）
    //后置通知不能访问目标方法执行的结果
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    //该方法是返回通知：在目标方法正常结束后执行
    //返回通知可以访问返回值
    @AfterReturning( value = "declareJoinPointExpression()",returning = "result" )
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    //该方法是异常通知：在目标方法出现异常时执行
    //可以访问异常对象，且可以指定在出现特定的异常时在执行的通知
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "ex" )
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception " + ex);
    }

    /*//环绕通知需要携带ProceedingJoinPoint类型的参数
    //环绕通知类似动态代理的全过程ProceedingJoinPoint的参数类型可以决定是否执行目标方法
    //且环绕通知必须有返回值，返回值即为目标方法的返回值
    @Around("declareJoinPointExpression()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //后置通知
            System.out.println("The method " + methodName + " ends ");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //异常通知
            System.out.println("The method " + methodName + " occurs exception " + throwable);
        }
        //返回通知
        System.out.println("The method " + methodName + " ends with " + result);
        return result;
    }*/
}
