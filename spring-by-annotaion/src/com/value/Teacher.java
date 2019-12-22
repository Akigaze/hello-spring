package com.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
@Component 优先使用添加了@Autowired的构造方法
然后是无参构造方法
最后才是其他构造方法
 */
@Component
public class Teacher {
  private String name;

  public Teacher() {
  }

  @Autowired
  public Teacher(@Value("Mayumi") String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Teacher{" +
      "name='" + name + '\'' +
      '}';
  }
}
