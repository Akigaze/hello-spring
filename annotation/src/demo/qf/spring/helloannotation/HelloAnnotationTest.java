package demo.qf.spring.helloannotation;

import demo.qf.spring.helloannotation.inner.InnerEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAnnotationTest {
  public static void main(String[] args) {
    String configLocation = "classpath:com/helloannotation/helloAnnotationApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    Entity entity = (Entity) context.getBean("entity");
    Entity myEntity = (Entity) context.getBean("myEntity");
    InnerEntity innerEntity = (InnerEntity) context.getBean("innerEntity");

    System.out.println(entity.getName());
    System.out.println(myEntity.getName());
    System.out.println(innerEntity);
  }
}
