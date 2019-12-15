package hellojavaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloJavaConfigTest {
  public static void main(String[] args){
    /*
    AnnotationConfigApplicationContext读取添加了@Configuration注解的类来加载IOC容器
    */
    ApplicationContext context = new AnnotationConfigApplicationContext(HelloJavaConfig.class);

    HelloBean helloBean = (HelloBean) context.getBean("helloBean");
    HelloBean otherHelloBean = (HelloBean) context.getBean("helloBean");

    helloBean.greet();
    otherHelloBean.greet();
  }

}
