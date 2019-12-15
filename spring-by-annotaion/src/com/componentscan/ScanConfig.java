package com.componentscan;

import com.componentscan.inner.Excavator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
/*
@ComponentScan 注解可以替代xml配置中的component-scan标签，开启组件扫描
不指定basePackage属性时，默认是注释的类所在的包及其子包
excludeFilters属性可以以指定的规则排除某些对某些包或类的扫描
参考： https://www.baeldung.com/spring-component-scanning
*/
//似乎@ComponentScan已经具备了@Configuration的功能????
@ComponentScan(basePackages = "com.componentscan",
  excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.componentscan\\.inner\\..*")}
)
public class ScanConfig {
  @Bean
  public Scanner scanMan() {
    Scanner scanner = new Scanner();
    scanner.setBand("Big Man");
    return scanner;
  }

  @Bean
  public Excavator myExcavator() {
    return new Excavator();
  }

}
