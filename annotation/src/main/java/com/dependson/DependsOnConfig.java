package com.dependson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/*
默认情况下，Spring会按照@Bean的顺序创建bean
使用@Component的bean似乎会比使用@Bean的早创建
*/

@Component
@ComponentScan
public class DependsOnConfig {
  @Bean
  /*
  @DependsOn 注解指定只有在被依赖的bean被创建，才能创建该bean
  若被依赖的bean不存在，则会抛出异常
  该注解可以使用在添加了@Bean的工厂方法上
  */
  @DependsOn("road1")
  public Vehicle vehicle1() {
    System.out.println("create bean vehicle1");
    return new Vehicle();
  }

  @Bean
  public Road road1() {
    System.out.println("create bean road1");
    return new Road();
  }
}

@Component
/*
@DependsOn 也可以使用在类上
*/
@DependsOn("vehicle")
class Road {
  Road() {
    System.out.println("Road: non argument constructor");
  }
}

@Component
class Vehicle {
  Vehicle() {
    System.out.println("Vehicle: non argument constructor");
  }
}
