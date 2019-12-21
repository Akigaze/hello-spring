package com.dependson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(DependsOnConfig.class);
    ((AnnotationConfigApplicationContext) context).close();
  }
}
