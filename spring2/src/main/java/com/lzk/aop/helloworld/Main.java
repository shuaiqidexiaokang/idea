package com.lzk.aop.helloworld;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int result = proxy.add(3,3);
        System.out.println(result);

    }
}
