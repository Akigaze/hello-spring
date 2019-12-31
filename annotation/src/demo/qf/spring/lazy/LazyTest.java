package demo.qf.spring.lazy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(LazyBeanConfig.class);

    System.out.println("---------- IOC container ready -----------");

    CPU cpu = (CPU) context.getBean("cpu");
    CPU ibmCpu = (CPU) context.getBean("ibmCpu");
    CPU cyrixCpu = (CPU) context.getBean("cyrixCpu");

    Laptop laptop = (Laptop) context.getBean("laptop");
    Laptop lenovoLaptop = (Laptop) context.getBean("lenovoLaptop");
    Laptop dellLaptop = (Laptop) context.getBean("dellLaptop");

    System.out.println(laptop.getCpu());
    System.out.println(lenovoLaptop.getCpu());
    System.out.println(dellLaptop.getCpu());

    System.out.println(laptop.getCpu() == cpu);
    System.out.println(lenovoLaptop.getCpu() == ibmCpu);
    System.out.println(dellLaptop.getCpu() == cyrixCpu);
  }
}
