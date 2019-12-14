package com.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class InjectionMain {
  public static void main(String[] args) {
    String configLocation = "com/injection/injectionApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    System.out.println("-------- beans of Car ---------");

    Car bmw = (Car) context.getBean("bmw");
    Car bench = (Car) context.getBean("bench");
    Car honda = (Car) context.getBean("honda");
    System.out.println(bmw);
    System.out.println(bench);
    System.out.println(honda);

    System.out.println("\n-------- car list -------\n");

    List cars = context.getBean("cars", ArrayList.class);
    System.out.println(cars);
    System.out.println(cars.get(0) == bmw);
    System.out.println(cars.get(1) == bench);

    System.out.println("\n-------- beans of Person ---------\n");

    Person tom = (Person) context.getBean("tom");
    Person james = (Person) context.getBean("james");
    Person sam = (Person) context.getBean("sam");

    System.out.println(tom);
    System.out.println(james);
    System.out.println(sam);

    System.out.println("is tom's car same to sam's: " + (tom.getCar() == sam.getCar()));
    System.out.println("is tom's car same to bench: " + (tom.getCar() == bench));
    System.out.println("is sam's car same to bench: " + (sam.getCar() == bench));
    System.out.println("is james's car same to bmw: " + (james.getCar() == bmw));

    System.out.println("\n-------- beans of Millionaire ---------\n");


    Millionaire laoWang = (Millionaire) context.getBean("laoWang");
    Millionaire xiaoWang = (Millionaire) context.getBean("xiaoWang");
    Millionaire maYun = (Millionaire) context.getBean("maTengTeng");
    System.out.println(laoWang);
    System.out.println(xiaoWang);
    System.out.println(maYun);
  }

}

