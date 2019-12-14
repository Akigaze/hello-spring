package com.beans.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Car {
    private String brand;
    private double price;
    private int maxSpeed;

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car bmw = (Car) context.getBean("bmw");
        Car bench = (Car) context.getBean("bench");
        List<Car> cars = (List<Car>) context.getBean("cars");
        System.out.println(cars);
//        System.out.println(bmw);
//        System.out.println(bench);
    }
}
