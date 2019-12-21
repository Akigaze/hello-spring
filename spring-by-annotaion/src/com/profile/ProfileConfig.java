package com.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class ProfileConfig {
  /*
  当activeProfiles存在指定的profile才会构建bean
  若activeProfiles为空，则只有当defaultProfiles存在指定profile才构建bean
   */
  @Bean
  @Profile("demo")
  public Demo demoBean() {
    System.out.println("create bean demo");
    return new Demo();
  }

  @Bean
  @Profile("dev")
  public Development developmentBean() {
    System.out.println("create bean development");
    return new Development();
  }

  /*
    不指定Profile时，不论在哪个profile下都会创建bean
  */
  @Bean
  public Default noProfile() {
    System.out.println("create bean noProfile");
    return new Default();
  }
}

@Component
@Profile("demo")
class Demo {
}

@Component
@Profile("dev")
class Development {
}

/*
默认情况下，Spring 的environmentConfig里面有一个名为default的默认profile
但是通过 setDefaultProfiles 等操作可以移除该默认profile
*/
@Component
@Profile("default")
class Default {
}
