package demo.qf.spring.ioc.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
  private String name;

  public HelloSpring() {
    System.out.println("use HelloSpring no args constructor");
  }

  public void setName(String name) {
    System.out.println("set HelloSpring name: " + name);
    this.name = name;
  }

  private void sayHello() {
    System.out.println("Hello " + this.name);
  }

  public static void main(String[] args) {
    String configPath = "classpath:demo/qf/spring/ioc/hello/applicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

    System.out.println("------ singleton bean -------");

    HelloSpring spring1 = (HelloSpring) context.getBean("spring");
    HelloSpring spring2 = context.getBean(HelloSpring.class);

    spring1.sayHello();
    spring2.sayHello();
    System.out.println(spring1 == spring2);
  }

}
