package demo.qf.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;


public class LogAspect {

  public void logBefore(JoinPoint point) {
    //point.getTarget() 获取正真正执行方法的对象
    String className = point.getTarget().getClass().getName();
    //point.getSignature() 获取切面命中的方法签名
    String methodName = point.getSignature().getName();
    //point.getArgs() 获取切面命中方法的实参数组
    List<Object> args = Arrays.asList(point.getArgs());
    System.out.println(String.format("Before execute %s %s %s", className, methodName, args.toString()));
  }

  //第二个参数为方法执行后的返回值，形参名需要与 .xml 中 aop:after-returning 标签的 returning 属性一致
  public void logReturn(JoinPoint point, Object result) {
    String className = point.getTarget().getClass().getName();
    String methodName = point.getSignature().getName();
    System.out.println(String.format("Return %s %s %s", className, methodName, result));
  }

  public void logAfter(JoinPoint point) {
    String className = point.getTarget().getClass().getName();
    String methodName = point.getSignature().getName();
    System.out.println(String.format("After %s %s", className, methodName));
  }

  //第二个参数为方法执行过程中抛出的异常，形参名需要与 .xml 中 aop:after-throwing 标签的 throwing 属性一致
  public void logException(JoinPoint point, Exception e) {
    String className = point.getTarget().getClass().getName();
    String methodName = point.getSignature().getName();
    String log = String.format("Exception %s %s %s", className, methodName, e.toString());
    System.out.println(log);
  }

  //ProceedingJoinPoint 包含了真正执行方法的对象，需要手动执行目标方法并将返回值返回
  public Object logAround(ProceedingJoinPoint point) throws Throwable {
    Object result = null;
    String className = point.getTarget().getClass().getName();
    String methodName = point.getSignature().getName();
    List<Object> args = Arrays.asList(point.getArgs());
    //前置通知
    System.out.println(String.format(">Before %s %s %s", className, methodName, args));
    try {
      //point.proceed() 执行真正的业务方法
      result = point.proceed();
      //返回通知
      System.out.println(String.format(">Return %s %s %s", className, methodName, result));
    } catch (Throwable throwable) {
      //异常通知
      System.out.println(String.format(">Exception %s %s %s", className, methodName, throwable.toString()));
//      throw throwable;
    }
    //后置通知
    System.out.println(String.format(">After %s %s", className, methodName));
    //代理对象的执行相应方法的返回值
    return result;
  }

}
