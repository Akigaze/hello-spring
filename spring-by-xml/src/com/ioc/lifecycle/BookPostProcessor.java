package com.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BookPostProcessor implements BeanPostProcessor {
  //postProcessBeforeInitialization 和 postProcessAfterInitialization 可以对bean对象进行修改、替换，再返回出去

  //在bean标签的init-method之前执行
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Book book = (Book) bean;
    System.out.println(beanName + " before init is " + book.getStatus() + ", will become purchased");
    book.setStatus("purchased");
    return bean;
  }

  //在bean标签的init-method之后执行
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Book book = (Book) bean;
    System.out.println(beanName + " after init is " + book.getStatus() + ", will become sold");
    book.setStatus("sold");
    return bean;
  }

}
