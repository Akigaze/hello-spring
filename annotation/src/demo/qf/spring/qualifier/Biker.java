package demo.qf.spring.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Biker {
  /*
    @Autowired 直接加在字段上时，会覆盖掉@Bean注解注入的属性
  */
  @Autowired
  @Qualifier("bike")
  private Vehicle vehicle;

  public Biker() {
  }

  /*
    @Qualifier不能直接用在构造方法上，只能加在构造方法的参数上
    且加在构造方法上的@Qualifier注解优先级要低于加在字段和setter上的
  */
  @Autowired
  public Biker(@Qualifier("car") Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  Vehicle getVehicle() {
    return vehicle;
  }

  /*
    @Autowired 加在setter上时，也会覆盖掉@Bean注解注入的属性,
    且setter上的@Autowired优先级高于加在字段上的
  */
  @Autowired
  @Qualifier("car")
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
