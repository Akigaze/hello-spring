package demo.qf.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/*
  @Value 可以实现字符串和数字，布尔值之间的自动转换，位于spring-beans包中
*/
@Configuration
public class SimpleValueConfig {
  @Bean
  public String myName(@Value("Akigaze") String name) {
    return name;
  }

  @Bean
  public Integer myAge(@Value("24") Integer age){
    return age;
  }

  @Bean
  public boolean isBoy(@Value("false") boolean isBoy){
    return isBoy;
  }

  /*
  若函数存在多个参数，@Value只添加在函数上时，Spring会使用给value为所有参数附上相同的值
  */
  @Bean
  @Value("Dad")
  public List<String> myParents(String father, String mother){
    return Arrays.asList(father, mother);
  }

  /*
    在不同参数前添加@Value可以为不同参数赋值
  */
  @Bean
  public List<String> myEyes(@Value("Sun") String right, @Value("Moon") String left){
    return Arrays.asList(right, left);
  }
}
