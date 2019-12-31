package demo.qf.spring.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(QualifierConfig.class);

    Biker bikerByBean = (Biker) context.getBean("bikerByBean");
    Biker bikerByComponent = (Biker) context.getBean("biker");
    Bike bike = (Bike) context.getBean("bike");
    Car car = (Car) context.getBean("car");

    System.out.println(bikerByBean.getVehicle());
    System.out.println(bikerByBean.getVehicle() == bike);
    System.out.println(bikerByBean.getVehicle() == car);

    System.out.println(bikerByComponent.getVehicle());
    System.out.println(bikerByComponent.getVehicle() == bike);
    System.out.println(bikerByComponent.getVehicle() == car);
  }
}
