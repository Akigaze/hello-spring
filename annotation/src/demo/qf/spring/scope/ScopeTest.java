package demo.qf.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

    System.out.println("------- IOC container ready -------");

    Animal pigX = (Animal) context.getBean("pig");
    Animal pigY = (Animal) context.getBean("pig");
    Animal bird1 = (Animal) context.getBean("bird");
    Animal bird2 = (Animal) context.getBean("bird");

    System.out.println(pigX == pigY);
    System.out.println(bird1 == bird2);
  }
}
