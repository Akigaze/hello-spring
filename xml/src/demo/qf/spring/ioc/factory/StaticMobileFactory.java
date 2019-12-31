package demo.qf.spring.ioc.factory;

public class StaticMobileFactory {
  //单例模式下该方法只会被执行一次
  public static Mobile produceMobile(String brand, int price, double size) {
    System.out.println("StaticMobileFactory: get bean");
    Mobile mobile = new Mobile();
    mobile.setBrand(brand);
    mobile.setPrice(price);
    mobile.setSize(size);
    mobile.setFactory("StaticMobileFactory");
    return mobile;
  }

}

