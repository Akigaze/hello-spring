package com.ioc.injection;

public class Person {
  private String name;
  private int age;
  private Car car;

  public Person() {
    System.out.println("use Person no arg constructor");
  }

  public Person(String name, int age, Car car) {
    System.out.println("use Person all args constructor");
    this.name = name;
    this.age = age;
    this.car = car;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", car=" + car +
      '}';
  }

}

