package com.factory;

import org.springframework.beans.factory.FactoryBean;

public class MobileBeanFactory implements FactoryBean<Mobile> {
  private Mobile mobile = new Mobile();
  private String brand;

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @Override
  public Mobile getObject() throws Exception {
    this.mobile.setBrand(this.brand);
    return this.mobile;
  }

  @Override
  public Class<?> getObjectType() {
    return this.mobile.getClass();
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
