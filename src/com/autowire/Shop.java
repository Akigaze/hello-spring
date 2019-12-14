package com.autowire;

public class Shop {
  private String name;
  private boolean open;
  private Address address;
  private Boss boss;

  public Shop() {
    System.out.println("use Shop no args constructor");
  }

  public void setName(String name) {
    this.name = name;
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

  public void setBoss(Boss boss) {
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

}
