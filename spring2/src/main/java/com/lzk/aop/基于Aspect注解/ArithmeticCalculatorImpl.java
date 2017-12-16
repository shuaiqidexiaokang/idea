package com.lzk.aop.基于Aspect注解;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
