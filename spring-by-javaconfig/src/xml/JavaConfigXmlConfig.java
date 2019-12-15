package xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
/*
@ImportResource 注解能直接将xml配置中的bean加载到java配置类中
*/
@ImportResource("classpath:xml/javaconfigXmlApplicationContext.xml")
public class JavaConfigXmlConfig {
  @Bean
  public CDPlayer player() {
    return new CDPlayer();
  }

  @Bean
  public Musician musician(CDPlayer cdPlayer) {
    return new Musician("Beethoven", cdPlayer);
  }
}
