package com.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class QualifierConfig {

  @Bean
  public Vehicle bike() {
    return new Bike();
  }

  @Bean
  public Vehicle car() {
    return new Car();
  }

  /*
    @Qualifier 注解在存在多个符合条件的bean的情况下，可以指定要注入的bean的名称
  */
  @Bean
  public Biker bikerByBean(@Qualifier("bike") Vehicle vehicle) {
    Biker biker = new Biker(vehicle);
    System.out.println("Biker from configuration: " + biker.getVehicle());
    return biker;
  }
}

interface Vehicle {
}

class Bike implements Vehicle{
}

class Car implements Vehicle{
}
