package com.antowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireAnnotationTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AutowireAnnotationConfig.class);

    Car car = (Car) context.getBean("car");
    Engine plainEngine = (Engine) context.getBean("plainEngine");
    Engine autowireEngine = (Engine) context.getBean("autowireEngine");
    Engine constructorEngine = (Engine) context.getBean("constructorEngine");

    System.out.println(car);
    System.out.println(plainEngine);
    System.out.println(autowireEngine);
    System.out.println(constructorEngine);

    System.out.println(car.getAutowireEngine() == autowireEngine);
    System.out.println(car.getPlainEngine() == plainEngine);
    System.out.println(car.getConstructorEngine() == constructorEngine);
  }
}
