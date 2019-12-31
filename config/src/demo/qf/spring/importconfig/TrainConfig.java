package demo.qf.spring.importconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainConfig {
  @Bean
  public Train train() {
    return new Train();
  }

}
