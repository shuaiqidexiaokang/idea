package com.lzk.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
    //要代理的对象
    private ArithmeticCalculator targer;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator targer) {
        this.targer = targer;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;
        //代理对象由哪一个类加载器加载
        ClassLoader loader = targer.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class [] interfaces = new Class[]{ArithmeticCalculator.class};
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 *proxy:正在返回的那个代理对象，一般情况下，在invoke不调用
                 *method：正在被调用的方法
                 * args：调用方法时，传入的参数
                 */
                String methodName = method.getName();
                System.out.println("The method " +methodName + " begins with " + Arrays.asList(args));
                Object result = method.invoke(targer,args);
                System.out.println("The method " +methodName + " ends with " + result);
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,invocationHandler);
        return proxy;
    }
}
