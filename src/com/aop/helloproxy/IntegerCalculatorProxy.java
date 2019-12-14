package com.aop.helloproxy;

import com.aop.universal.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IntegerCalculatorProxy {
    private Calculator target;

    IntegerCalculatorProxy(Calculator calculator) {
        this.target = calculator;
    }

    Calculator getProxy(){
        ClassLoader loader = this.target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Calculator.class};
        InvocationHandler handler = (proxy, method, args) -> {
            System.out.println(String.format("Execute Calculator %s with %s", method.getName(), Arrays.toString(args)));
            Object result = method.invoke(this.target, args);
            System.out.println(String.format("Execute Calculator %s result is %s", method.getName(), result.toString()));
            return result;
        };
        Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Calculator) proxy;
    }

}
