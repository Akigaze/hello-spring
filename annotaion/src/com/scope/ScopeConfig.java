package com.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
  @Bean
  public Animal pig() {
    return new Animal("pig");
  }

  /*
    @Scope 标注bean的作用范围
    可选值有singleton单例，prototype原型，request，session，globalSession 和其他自定义作用域
  */
  @Bean
  @Scope("prototype")
  public Animal bird() {
    return new Animal("bird");
  }
}

class Animal {
  private String species;

  Animal(String species) {
    System.out.println("Animal constructor with species: " + species);
    this.species = species;
  }
}
