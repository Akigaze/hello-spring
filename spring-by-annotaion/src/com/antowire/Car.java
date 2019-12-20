package com.antowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
@Autowired 注解支持属性注入，构造方法注入和setter注入
 */

@Component
public class Car {
  private Engine plainEngine;
  /*
    @Autowired 添加在field上时，Spring会使用反射注入属性，而不是构造方法或者setter
  */
  @Autowired
  private Engine autowireEngine;
  private Engine constructorEngine;
  /*
    当注释了@Autowired 的属性找不到合适的值注入时会抛出异常
    required 属性设置成false时可以不强制注入值
  */
//  @Autowired(required = false)
  private Wheel wheel;

  public Car() {
    System.out.println("Car: non arguments constructor");
  }

  /*
    Spring 优先会使用添加了@Autowired的构造方法创建对象
  */
  @Autowired
  public Car(Engine constructorEngine) {
    System.out.println("Car: constructor with constructorEngine");
    this.constructorEngine = constructorEngine;
  }

  /*
    添加了@Autowired的setter会被自动执行，同时也是默认参数要不为null
  */
  @Autowired
  public void setPlainEngine(Engine plainEngine) {
    System.out.println("Car: set plainEngine");
    this.plainEngine = plainEngine;
  }

  public Engine getPlainEngine() {
    return plainEngine;
  }

  public Engine getAutowireEngine() {
    return autowireEngine;
  }

  public Engine getConstructorEngine() {
    return constructorEngine;
  }

  @Override
  public String toString() {
    return "Car{" +
      "plainEngine=" + plainEngine +
      ", autowireEngine=" + autowireEngine +
      ", constructorEngine=" + constructorEngine +
      ", wheel=" + wheel +
      '}';
  }
}
