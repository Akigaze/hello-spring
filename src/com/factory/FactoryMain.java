package com.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {
  public static void main(String[] args) {
    String configLocation = "com/factory/factoryApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    Mobile huaWeiPhone = (Mobile) context.getBean("huawei");
    System.out.println(huaWeiPhone);

    Mobile viVoPhone = (Mobile) context.getBean("vivo");
    System.out.println(viVoPhone);

    Mobile miPhone = (Mobile) context.getBean("mi");
    System.out.println(miPhone);

    System.out.println("-----------------");
    System.out.println(huaWeiPhone == context.getBean("huawei"));
    System.out.println(viVoPhone == context.getBean("vivo"));
    System.out.println(miPhone == context.getBean("mi"));
  }

}

