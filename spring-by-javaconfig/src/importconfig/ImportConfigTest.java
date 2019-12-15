package importconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportConfigTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    Train train = (Train) context.getBean("train");
    Airplane airplane = (Airplane) context.getBean("airplane");

    train.run();
    airplane.fly();
  }

}
