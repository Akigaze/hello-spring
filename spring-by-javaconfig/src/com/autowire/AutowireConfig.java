package com.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireConfig {
  @Bean
  public Person person() {
    return new Person("Ma Yun Yun");
  }

  //默认自动注入参数，参数名与已有bean的id匹配
  @Bean
  public House house(Person person) {
    return new House(100, person);
  }

  /*
   但不存在id与参数名一致的bean是，会自动选择类型兼容的bean进行注入
   但当存在多个类型兼容的bean是，就会报错了
  */
  @Bean
  public House oldHouse(Person person1) {
    return new House(100, person1);
  }
}
