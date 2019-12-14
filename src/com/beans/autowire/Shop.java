package com.beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Shop {
  private String name;
  private boolean open;
  private Address address;
  private Entrepreneur boss;

  public Shop() {
    System.out.println("create shop bean");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Entrepreneur getBoss() {
    return boss;
  }

  public void setBoss(Entrepreneur boss) {
    this.boss = boss;
  }

  @Override
  public String toString() {
    return "Shop{" +
      "name='" + name + '\'' +
      ", open=" + open +
      ", address=" + address +
      ", boss=" + boss +
      '}';
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("bean-autowire-config.xml");
    Shop qiLinNanShop = (Shop) context.getBean("qi-lin-nan");
    System.out.println(qiLinNanShop);
    Shop wuShanShop = (Shop) context.getBean("qi-lin-nan");
    System.out.println(wuShanShop);
  }
}
