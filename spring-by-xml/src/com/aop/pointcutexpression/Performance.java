package com.aop.pointcutexpression;

public interface Performance {
  void perform();
}

/*
  1. execution() 声明一个方法表达式作为切点
  execution(* com.aop.*.Performance.perform(..))

  2. within() 限定必须是 com.aop.annotation 包中的类
  使用 &&(and), ||(or) 连接多个条件，!(not) 取反
  execution(* com.aop.*.Performance.perform(..) && within(com.aop.annotation.*))

  3. bean() 指示器由Spring提供，限定指定ID或名称的bean
  execution(* com.aop.*.Performance.perform(..) and bean('woodstock'))
  execution(* com.aop.*.Performance.perform(..) and !bean('woodstock'))
 */
