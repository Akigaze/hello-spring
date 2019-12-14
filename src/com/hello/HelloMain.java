package com.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
    public static final String APPLICATION_CONFIG_FILE_PATH = "applicationContext.xml";
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONFIG_FILE_PATH);
        HelloSpring spring1 = (HelloSpring) context.getBean("spring");
        HelloSpring spring2 = context.getBean(HelloSpring.class);
        spring1.sayHello();
        spring2.sayHello();
    }
}
