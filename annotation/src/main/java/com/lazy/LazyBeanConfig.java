package com.lazy;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@Import(LazyConfig.class)
public class LazyBeanConfig {
  /*
    @Lazy的bean在被其他的bean工厂方法依赖到时，也会进行相应的初始化
   */
  @Lazy
  @Bean
  public CPU cyrixCpu() {
    System.out.println("create bean cyrixCpu");
    return new CPU();
  }

  @Lazy
  @Bean
  public Laptop dellLaptop(CPU cyrixCpu) {
    System.out.println("create bean lenovoLaptop");
    return new Laptop(cyrixCpu);
  }
}
