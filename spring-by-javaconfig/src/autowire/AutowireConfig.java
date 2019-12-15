package autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireConfig {
  @Bean
  public Person person() {
    return new Person("Ma Yun Yun");
  }

  //默认自动注入参数
  @Bean
  public House house(Person person) {
    return new House(100, person);
  }
}
