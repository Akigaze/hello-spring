package com.ioc.factory;

public class Mobile {
  private String brand;
  private int price;
  private double size;
  private String factory;

  public Mobile() {
    System.out.println("use Mobile no args constructor");
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  void setPrice(int price) {
    this.price = price;
  }

  void setSize(double size) {
    this.size = size;
  }

  void setFactory(String factory) {
    this.factory = factory;
  }

  @Override
  public String toString() {
    return "Mobile{" +
      "brand='" + brand + '\'' +
      ", price=" + price +
      ", size=" + size +
      ", factory='" + factory + '\'' +
      '}';
  }
}
