package com.factory;

public class InstanceMobileFactory {
  public Mobile productMobile(String brand) {
    Mobile mobile = new Mobile();
    mobile.setBrand(brand);
    return mobile;
  }
}
