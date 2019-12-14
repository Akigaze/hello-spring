package com.ioc.autowire;

public class Address {
  private String city;
  private String street;
  private int number;

  public Address() {
    System.out.println("use Address no args constructor");
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Address{" +
      "city='" + city + '\'' +
      ", street='" + street + '\'' +
      ", number=" + number +
      '}';
  }

}
