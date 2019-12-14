package com.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeSpring {
  private String name;

  public ScopeSpring() {
    System.out.println("use ScopeSpring no args constructor");
  }

  public void setName(String name) {
    System.out.println("set ScopeSpring name: " + name);
    this.name = name;
  }

  @Override
  public String toString() {
    return "ScopeSpring{" +
      "name='" + name + '\'' +
      '}';
  }

  public static void main(String[] args){
    String configPath = "classpath:com/scope/scopeApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

    System.out.println("\n------ prototype bean -------\n");

    ScopeSpring bean1 = (ScopeSpring) context.getBean("new-bean");
    ScopeSpring bean2 = (ScopeSpring) context.getBean("new-bean");
    ScopeSpring bean3 = context.getBean(ScopeSpring.class);

    System.out.println(bean1);
    System.out.println(bean2);
    System.out.println(bean3);
    System.out.println(bean1 == bean2);
    System.out.println(bean1 == bean3);
    System.out.println(bean2 == bean3);
  }

}
