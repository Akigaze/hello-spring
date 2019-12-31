package demo.qf.spring.stereotype;

import demo.qf.spring.stereotype.module.StereotypeComponent;
import demo.qf.spring.stereotype.module.StereotypeController;
import demo.qf.spring.stereotype.module.StereotypeRepository;
import demo.qf.spring.stereotype.module.StereotypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
@Configuration 和 @ComponentScan 也可以添加在启动类上
*/
@Configuration
/*
还有一个叫 @ComponentScans 注解，它允许合并多个 @ComponentScan 注解的信息
*/
@ComponentScan
public class StereotypeAnnotationTest {
  public static void main(String[] args) {
    /*
      将本类设置成配置类，添加 @Configuration 和 @ComponentScan
    */
    ApplicationContext context = new AnnotationConfigApplicationContext(StereotypeAnnotationTest.class);


    /*
      @Controller
      @Service
      @Repository
      @Component
      是Spring用于组件扫描，自动构建bean的表示，处于spring-context的stereotype包中
      从本质上讲，他们都是 @Component，但是名字不同就赋予了不同的业务含义
     */

    StereotypeController stereotypeController = (StereotypeController) context.getBean("stereotypeController");
    StereotypeService stereotypeService = (StereotypeService) context.getBean("stereotypeService");
    StereotypeRepository stereotypeRepository = (StereotypeRepository) context.getBean("stereotypeRepository");
    StereotypeComponent stereotypeComponent = (StereotypeComponent) context.getBean("stereotypeComponent");

    System.out.println(stereotypeController.getService());
    System.out.println(stereotypeController.getService() == stereotypeService);
    System.out.println(stereotypeService.getRepository());
    System.out.println(stereotypeService.getRepository() == stereotypeRepository);
    System.out.println(stereotypeComponent);
  }
}
