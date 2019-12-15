package autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AutowireConfig.class);

    Person person = (Person) context.getBean("person");
    House house = (House) context.getBean("house");

    System.out.println(person);
    System.out.println(house);
    System.out.println(house.getHost() == person);
  }
}
