package com.hellojavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
  @Configuration 注解指明该类是一个Spring bean的配置类
  使用java类配置bean的方式，替代了xml配置bean
  要是用 AnnotationConfigApplicationContext(Class) 加载配置类
*/
@Configuration
public class HelloJavaConfig {
  /*
  @Bean 注解与xml配置的bean标签类似，只能在标注了@Configuration的类中使用
  该注解标注的是一个工厂方法
  注解要作用在方法上，方法名相当于bean的id
  默认情况加@Bean使用单例模式，在初始化IOC容器是就会构建bean对象
  */
  @Bean
  public HelloBean helloBean() {
    System.out.println("HelloJavaConfig.helloBean: get HelloBean object");
    HelloBean bean = new HelloBean();
    bean.setText("Morning");
    return bean;
  }

  /*
    @Bean 注解的name或value属性可以设置bean的名称，设置时工厂方法的方法名将不再作为bean的名字
  */
  @Bean("helloWorld")
  public HelloBean anotherHelloBean() {
    System.out.println("HelloJavaConfig.anotherHelloBean: get HelloBean object, but the bean name is helloWorld");
    HelloBean bean = new HelloBean();
    bean.setText("Hello World");
    return bean;
  }
}
