package demo.qf.spring.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
@Value 加在字段上时，应该是使用反射的方式注入属性值的
它会在构造方法执行之后为字段注入值
@Autowired也是一样的
 */
@Component
public class Clazz {
  private Integer grade;
  @Value("4")
  private Integer number;
  @Value("B1-3F-02")
  private String room;
  @Value("30")
  private Integer numberOfStudent;
  @Autowired
  private Teacher headTeacher;

  public Clazz() {
    System.out.println("Clazz non argument constructor");
  }

  /*
    Spring 在自动构建bean执行构造方法时，会从上下文查找合适的值作为构造方法参数的值
    先查找同名的bean，再查找同类的bean
    所以如果使用的是带参的构造方法，相应那部分字段是不用添加@Autowired注解的
  */
  public Clazz(Integer grade, Integer number, String room, Integer numberOfStudent, Teacher headTeacher) {
    System.out.println("Clazz all arguments constructor");
    this.grade = grade;
    this.number = number;
    this.room = room;
    this.numberOfStudent = numberOfStudent;
    this.headTeacher = headTeacher;
  }

  /*
    @Value 添加在setter上也有@Autowired一样的作用，会被自动执行，为属性注入值
    但是若加在setter的属性上就不会自动执行，@Autowired 也是一样的
  */
  @Value("5")
  public void setGrade(Integer grade) {
    System.out.println("Clazz set grade: " + grade);
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Clazz{" +
      "grade=" + grade +
      ", number=" + number +
      ", room='" + room + '\'' +
      ", numberOfStudent=" + numberOfStudent +
      ", headTeacher=" + headTeacher +
      '}';
  }
}
