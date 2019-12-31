package com.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class PrimaryConfig {
  @Bean
  public Driver truck(Vehicle vehicle) {
    Driver driver = new Driver();
    driver.setVehicle(vehicle);
    return driver;
  }

  @Bean
  public Biker bicycle(Vehicle vehicle) {
    Biker biker = new Biker();
    biker.setVehicle(vehicle);
    return biker;
  }
}

interface Vehicle {
}

/*
当同一类型的bean存在多个时，除了使用@Qualifier指定注入的bean的名称外
可以通过@Primary将某一个bean标注为这一类型的bean中主要的一个，Spring注入选择困难时，就会选择主要的一个
 */
@Primary
@Component
class Car implements Vehicle {
}

@Component
class Bike implements Vehicle {
}

@Component
class Driver {
  @Autowired
  Vehicle vehicle;

  Vehicle getVehicle() {
    return vehicle;
  }

  void setVehicle(Vehicle vehicle) {
    System.out.println("Driver set vehicle " + vehicle);
    this.vehicle = vehicle;
  }
}

@Component
class Biker {
  /*
  @Autowired 会把@Bean中注入的属性值重写掉
   */
  @Autowired
  @Qualifier("bike")
  Vehicle vehicle;

  Vehicle getVehicle() {
    return vehicle;
  }

  void setVehicle(Vehicle vehicle) {
    System.out.println("Biker set vehicle " + vehicle);
    this.vehicle = vehicle;
  }
}
