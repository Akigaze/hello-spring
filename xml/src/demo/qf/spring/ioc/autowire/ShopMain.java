package demo.qf.spring.ioc.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopMain {
  public static void main(String[] args) {
    String configLocation = "demo/qf/spring/ioc/autowire/autowireApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    // 标记为abstract的bean不能直接用来构建对象
    //Address abstractAddress = (Address) context.getBean("abstract-address");
    //System.out.println("abstract-address: " + abstractAddress);

    Address realAddress = (Address) context.getBean("address");
    System.out.println("address: " + realAddress);

    System.out.println("\n---------------------\n");

    Shop qiLinNanShop1 = (Shop) context.getBean("qi-lin-nan");
    Shop qiLinNanShop2 = (Shop) context.getBean("qi-lin-nan");
    System.out.println(qiLinNanShop1);
    System.out.println(qiLinNanShop1.getAddress() == qiLinNanShop2.getAddress());

    System.out.println("\n---------------------\n");

    Shop wuShanShop = (Shop) context.getBean("wu-shan");
    System.out.println(wuShanShop);
    System.out.println(wuShanShop.getAddress() == qiLinNanShop1.getAddress());
    Shop tianMaoShop = (Shop) context.getBean("tian-mao");
    System.out.println(tianMaoShop);
    System.out.println(wuShanShop.getAddress() == tianMaoShop.getAddress());
  }

}
