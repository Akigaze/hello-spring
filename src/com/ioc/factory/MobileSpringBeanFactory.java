package com.ioc.factory;

import org.springframework.beans.factory.FactoryBean;

public class MobileSpringBeanFactory implements FactoryBean<Mobile> {
  private Mobile mobile = new Mobile();
  private String brand;

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  //单例模式下该方法只会被执行一次
  @Override
  public Mobile getObject() {
    System.out.println("MobileSpringBeanFactory: get bean");
    this.mobile.setBrand(this.brand);
    this.mobile.setFactory("factory implements org.springframework.beans.factory.FactoryBean");
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

