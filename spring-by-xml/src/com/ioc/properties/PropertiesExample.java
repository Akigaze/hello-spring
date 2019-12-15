package com.ioc.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class PropertiesExample {
  private Properties props;

  public void setProps(Properties props) {
    this.props = props;
  }

  @Override
  public String toString() {
    return "PropertiesExample{" +
      "props=" + props +
      '}';
  }

  public static void main(String[] args) {
    String configLocation = "com/ioc/properties/propertiesApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    PropertiesExample mysqlConn = context.getBean(PropertiesExample.class);
    System.out.println(mysqlConn);
  }
}
