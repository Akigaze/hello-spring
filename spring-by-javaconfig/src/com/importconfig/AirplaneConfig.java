package com.importconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirplaneConfig {
  @Bean
  public Airplane airplane() {
    return new Airplane();
  }

}
