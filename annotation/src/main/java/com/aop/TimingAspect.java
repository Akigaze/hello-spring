package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
@Aspect, @Pointcut, @Before, @After 等AOP注解都是 aspectjrt 包中的内容，只是Spring整合AspectJ的东西
Link：https://www.baeldung.com/spring-aop-pointcut-tutorial
*/

/*
切面对象也必须初始化，所以要添加@Component注解
必须通过 @Aspect 注解明确指明是一个切面
*/
@Component
@Aspect
public class TimingAspect {
  /*
    @Pointcut 注解使用pointcut expression声明切面
  */
  @Pointcut("execution(* com.aop.Factory.startWorking(..))")
  public void factoryWorkingPointcut() {
  }

  /*
    @annotation 指示器(Pointcut Designator PCD) 限定了只有添加了指定注解的方法才命中切点
    "&&" 连接多个切点指示器，扩展切点条件
    可以在切点使用 @annotation 限制带有某些注解的方法
  */
  @Pointcut("execution(* com.aop.Worker.*(..)) && @annotation(com.aop.Loggable)")
  public void workerWorkingPointcut() {
  }

  @Before("factoryWorkingPointcut()")
  public void logStart(JoinPoint point) {
    String methodName = point.getSignature().getName();
    System.out.println(String.format("Factory start %s at %s", methodName, Utils.prettyNow()));
  }

  @After("factoryWorkingPointcut()")
  public void logEnd(JoinPoint point) {
    String methodName = point.getSignature().getName();
    System.out.println(String.format("Factory end %s at %s", methodName, Utils.prettyNow()));
  }

  // 在具体的切面使用 @annotation 使用变量接收方法上的注解
  @Around("workerWorkingPointcut() && @annotation(loggable)")
  public Object workerLog(ProceedingJoinPoint point, Loggable loggable) throws Throwable {
    String methodName = point.getSignature().getName();
    String name = ((Worker) (point.getTarget())).getName();
    Date startTime = new Date();
    System.out.println("-----------------");
    System.out.println(String.format("Worker %s start %s at %s, with description %s", name, methodName, Utils.prettyDate(startTime), loggable.desc()));
    Object result = null;
    try {
      result = point.proceed();
    } catch (Throwable ignored) {
      throw ignored;
    }
    Date endTime = new Date();
    System.out.println(String.format("Worker %s end %s at %s", name, methodName, Utils.prettyDate(endTime)));
    System.out.println(String.format("Worker %s cost %sms to %s", name, Utils.timeInterval(endTime, startTime), methodName));
    return result;
  }

  /*
    @AfterReturning 只有在方法真正return才起作用
    切面方法接收返回值的参数名必须与 returning 属性指定的名称一致
  */
  @AfterReturning(value = "workerWorkingPointcut()", returning = "product")
  public void workProduceLog(JoinPoint point, Object product) {
    System.out.println(String.format("Worker work out %s", product));
    System.out.println("-----------------");
  }

  /*
    @AfterThrowing 只有在方法抛出异常才起作用
    切面方法接收异常对象的参数名必须与 throwing 属性指定的名称一致
  */
  @AfterThrowing(value = "workerWorkingPointcut()", throwing = "exception")
  public void workOccurException(JoinPoint point, Exception exception) {
    System.out.println("Worker occur some exception: " + exception.getMessage());
    exception.printStackTrace();
    System.out.println("-----------------");
  }
}

class Utils {
  private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

  static String prettyNow() {
    return Utils.prettyDate(new Date());
  }

  static String prettyDate(Date date) {
    return Utils.format.format(date);
  }

  static int timeInterval(Date end, Date start) {
    return (int) (end.getTime() - start.getTime());
  }
}
