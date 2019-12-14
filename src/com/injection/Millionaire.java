package com.injection;

import java.util.List;
import java.util.Map;

public class Millionaire {
  private String name;
  private int age;
  private long asset;
  private List<Car> cars;
  private Map<String, Person> servants;

  public Millionaire() {
    System.out.println("use Millionaire non argument constructor");
  }

  public Millionaire(String name, int age, long asset, List<Car> cars) {
    System.out.println("use Millionaire name, age, asset, cars arguments constructor");
    this.name = name;
    this.age = age;
    this.asset = asset;
    this.cars = cars;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setAsset(long asset) {
    this.asset = asset;
  }

  public void setServants(Map<String, Person> servants) {
    this.servants = servants;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  @Override
  public String toString() {
    return "Millionaire{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", asset=" + asset +
      ", cars=" + cars +
      ", servants=" + servants +
      '}';
  }

}

