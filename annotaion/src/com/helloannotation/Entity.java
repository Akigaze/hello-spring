package com.helloannotation;

import org.springframework.stereotype.Component;

/*
@Component 注解添加在类上，会构建一个bean加入Spring IOC 容器管理
bean的名称(id) 默认为类名首字母小写
注解的参数指定bean的名称
但是这个注解无法为bean的属性注入值

需要在Spring组件扫描的包范围内才生效，即需要依赖 xml配置的context:component-scan 或Java配置的 @ComponentScan
*/
@Component
public class Entity {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
