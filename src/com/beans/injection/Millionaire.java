package com.beans.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class Millionaire {
  private String name;
  private int age;
  private long asset;
  private List<Car> cars;
  private Map<String, Person> servants;

  public Millionaire() {
  }

  public Millionaire(String name, int age, long asset, List<Car> cars) {
    this.name = name;
    this.age = age;
    this.asset = asset;
    this.cars = cars;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getAsset() {
    return asset;
  }

  public void setAsset(long asset) {
    this.asset = asset;
  }

  public List<Car> getCars() {
    return cars;
  }

  public Map<String, Person> getServants() {
    return servants;
  }

  public void setServants(Map<String, Person> servants) {
    this.servants = servants;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  @Override
  public String toString() {
    return "Millionaire:\n\r" +
      "name= " + name +
      "\n\rage= " + age +
      "\n\rasset= " + asset +
      "\n\rcars= " + cars +
      "\n\rservant= " + servants;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Millionaire laoWang = (Millionaire) context.getBean("LaoWang");
//        Millionaire xiaoWang = (Millionaire) context.getBean("xiao-wang");
    Millionaire maYun = (Millionaire) context.getBean("ma-yun");
//        System.out.println(laoWang);
//        System.out.println(xiaoWang);
    System.out.println(maYun);
  }
}
