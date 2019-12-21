package com.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/*
@Lazy 添加在@Configuration的类上时，类中所有的@Bean工厂方法只有在相应的bean被使用到时才会执行
*/
@Lazy
@Configuration
public class LazyConfig {
  /*
    @Lazy 的参数设置为false可以禁用懒加载
    这个可以消除@Lazy添加在类上时对所有bean的作用
  */
  @Bean
  @Lazy(false)
  public CPU ibmCpu() {
    System.out.println("create bean ibmCpu");
    return new CPU();
  }

  @Bean
  public Laptop lenovoLaptop(CPU ibmCpu) {
    System.out.println("create bean lenovoLaptop");
    return new Laptop(ibmCpu);
  }
}
