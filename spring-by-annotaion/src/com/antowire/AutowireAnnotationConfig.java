package com.antowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class AutowireAnnotationConfig {

  @Bean
  public Engine plainEngine() {
    return new Engine("plainEngine BongBong");
  }

  @Bean
  public Engine autowireEngine() {
    return new Engine("autowireEngine BongBong");
  }

  @Bean
  public Engine constructorEngine() {
    return new Engine("constructorEngine BongBong");
  }
}
