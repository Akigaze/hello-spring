package com.autowire;

public class Boss {
  private String name;
  private int age;
  private long asset;

  public Boss() {
    System.out.println("use Boss no args constructor");
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

  @Override
  public String toString() {
    return "Boss{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", asset=" + asset +
      '}';
  }

}
