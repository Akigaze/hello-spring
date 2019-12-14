package com.ioc.factory;

public class InstanceMobileFactory {
  //单例模式下该方法只会被执行一次
  public Mobile produceMobile(String brand, int price, double size) {
    System.out.println("InstanceMobileFactory: get bean");
    Mobile mobile = new Mobile();
    mobile.setBrand(brand);
    mobile.setPrice(price);
    mobile.setSize(size);
    mobile.setFactory("InstanceMobileFactory");
    return mobile;
  }

}

