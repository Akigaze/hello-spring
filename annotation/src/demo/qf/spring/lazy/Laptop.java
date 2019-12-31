package demo.qf.spring.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
@Lazy 加载类上可以让类的实体进行懒加载
加载属性，构造方法，setter上可以让被依赖的bean实现懒加载
 */

@Component
public class Laptop {
  private CPU cpu;

  @Autowired
  public Laptop(@Lazy CPU cpu) {
    System.out.println("Laptop argument with cpu");
    this.cpu = cpu;
  }

  CPU getCpu() {
    return cpu;
  }
}

@Component("cpu")
class CPU {
  CPU() {
    System.out.println("CPU non argument constructor");
  }
}
