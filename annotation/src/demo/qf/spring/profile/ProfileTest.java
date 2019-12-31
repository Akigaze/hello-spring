package demo.qf.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileTest {
  public static void main(String[] args) {
    /*
      AnnotationConfigApplicationContext 的带参构造方法会同时执行 register 和 refresh方法
      而无参构造方法则需要手动执行，因此可以在IOC容器启动之前做更多的配置
    */
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    System.out.println("------- 配置 profiles -------");
    ConfigurableEnvironment environment = context.getEnvironment();
    environment.setDefaultProfiles("demo", "dev");
    environment.addActiveProfile("demo");

    System.out.println("-------- 引入配置，初始化IOC容器 --------");
    context.register(ProfileConfig.class);
    /*
      对于一个ApplicationContext，refresh 只允许执行一次
      它会构建配置对象，初始化IOC容器等
      只有在 refresh 执行之前修改 profile 才有效
    */
    context.refresh();

    System.out.println(context.containsBean("demo"));
    System.out.println(context.containsBean("development"));
    System.out.println(context.containsBean("demoBean"));
    System.out.println(context.containsBean("developmentBean"));
    System.out.println(context.containsBean("default"));
    System.out.println(context.containsBean("noProfile"));
  }
}
