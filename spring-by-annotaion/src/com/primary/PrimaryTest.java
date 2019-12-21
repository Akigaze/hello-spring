package com.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(PrimaryConfig.class);

    Bike bike = (Bike) context.getBean("bike");
    Car car = (Car) context.getBean("car");

    Biker biker = (Biker) context.getBean("biker");
    Driver driver = (Driver) context.getBean("driver");

    Biker bicycle = (Biker) context.getBean("bicycle");
    Driver truck = (Driver) context.getBean("truck");

    System.out.println(biker.getVehicle());
    System.out.println(driver.getVehicle());
    System.out.println(biker.getVehicle() == bike);
    System.out.println(driver.getVehicle() == car);

    System.out.println(bicycle.getVehicle());
    System.out.println(truck.getVehicle());
    System.out.println(bicycle.getVehicle() == car);
    System.out.println(truck.getVehicle() == car);
  }
}
