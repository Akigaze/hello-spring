package demo.qf.spring.componentscan;

import demo.qf.spring.componentscan.exclude.Excavator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);

    Scanner scanner = (Scanner) context.getBean("scanner");
    Scanner scanMan = (Scanner) context.getBean("scanMan");
    Excavator myExcavator = (Excavator) context.getBean("myExcavator");
    scanner.setBand("Ipsen");

    scanner.scan();
    scanMan.scan();
    System.out.println(myExcavator);
    System.out.println("contains excavator: " + context.containsBean("excavator"));
  }
}
