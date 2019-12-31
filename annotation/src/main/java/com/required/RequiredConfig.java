package com.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class RequiredConfig {
  @Bean
  public Paper paper() {
    return new Paper();
  }

  /*
    @Required 注解对使用@Bean工厂方法的bean不起作用
  */
  @Bean
  public Book bookNotRequirePaper() {
    return new Book();
  }
}

class Paper {
}

@Component
class Book {
  private Paper paper;

  Paper getPaper() {
    return paper;
  }

  /*
      @Required 只是指明了该属性在Spring IOC容器创建bean的时候必须注入
      且@Required注解只能用于setter上，要使用该setter自动注入属性
      所以标记了@Required的setter也要标记@Autowired，而只标记在属性或构造方法上时没有用的
      但是该注解对使用@Bean注解的bean不使用
  */
  @Autowired
  @Required
  public void setPaper(Paper paper) {
    this.paper = paper;
  }
}
