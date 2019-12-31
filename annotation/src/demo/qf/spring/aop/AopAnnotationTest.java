package demo.qf.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
/*
使用注解配置AspectJ AOP时需要在@Configuration类上添加 @EnableAspectJAutoProxy 注解
等同于在xml配置文件中添加 <aop:aspectj-autoproxy/> 标签
*/
@EnableAspectJAutoProxy
public class AopAnnotationTest {
  @Bean
  public Worker xiaoMing() {
    return new Worker("Xiao Ming");
  }

  @Bean
  public Worker aWei() {
    return new Worker("A Wei");
  }

  @Bean
  public Worker wangFafa() {
    return new Worker("Wang Fafa");
  }


  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AopAnnotationTest.class);

    Factory myFactory = (Factory) context.getBean("myFactory");
    Worker xiaoMing = (Worker) context.getBean("xiaoMing");
    Worker aWei = (Worker) context.getBean("aWei");
    aWei.setIll(true);
    Worker wangFafa = (Worker) context.getBean("wangFafa");

    myFactory.hire(xiaoMing, aWei, wangFafa);

    myFactory.startWorking();

    System.out.println(myFactory.getProduct());
  }
}
