package com.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;


public class LogAspect {

    public void logBefore(JoinPoint point){

        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println(String.format("Before execute %s %s %s", className, methodName, args.toString()));
    }

    public void logReturn(JoinPoint point, Object result){
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        System.out.println(String.format("Return %s %s %s", className, methodName, result));
    }

    public void logAfter(JoinPoint point){
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        System.out.println(String.format("After %s %s", className, methodName));
    }

    public void logException(JoinPoint point, Exception e){
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String log = String.format("Exception %s %s %s", className, methodName, e.toString());
        System.out.println(log);
    }

    public Object logAround(ProceedingJoinPoint point) {
        Object result = null;
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        //前置通知
        System.out.println(String.format(">Before %s %s %s", className, methodName, args));
        try {
            //执行真正的业务方法
            result = point.proceed();
            //返回通知
            System.out.println(String.format(">Return %s %s %s", className, methodName, result));
        } catch (Throwable throwable) {
            //异常通知
            System.out.println(String.format(">Exception %s %s %s", className, methodName, throwable.toString()));
        }
        //后置通知
        System.out.println(String.format(">After %s %s", className, methodName));
        //代理对象的执行相应方法的返回值
        return result;
    }

}
