package com.lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BookPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("process " + beanName + " before init");
    ((Book) bean).setName("嫌疑人X的献身");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("process " + beanName + " after init");
    ((Book) bean).setName("解忧杂货铺");
    return bean;
  }
}
