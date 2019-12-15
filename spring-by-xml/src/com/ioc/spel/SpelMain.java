package com.ioc.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelMain {
  public static void main(String[] args){
    String configLocation = "com/ioc/spel/spelApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    Circle smallCircle = (Circle) context.getBean("smallCircle");
    System.out.println(smallCircle);

    City guangZhouCity = (City) context.getBean("guang-zhou-city");
    System.out.println(guangZhouCity);

    Ball basketball = (Ball) context.getBean("basketball");
    System.out.println(basketball);
  }

}

