package demo.qf.spring.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@ComponentScan
@Import({SimpleValueConfig.class, PropertyValueConfig.class})
public class ValueConfig {
  /*
    @Value 注解可以直接使用SpEL表达式
    当要获取的变量属性值不存在时，可以使用 "?:" 指定默认值
   */
  @Bean
  public Object spelWithDefault(@Value("#{systemProperties['unknown'] ?: 'some default'}") Object value) {
    return value;
  }

  /*
    对于properties文件中定义的列表属性，@Value中的spel会将其自动转成List或数组
    所以要把他当成字符串的话，需要添加单引号
    spel表达式也可以使许多java的函数
   */
  @Bean
  @Value("#{'${teacher}'.split(', ')}")
  public List<String> teacherList(List<String> teachers) {
    return teachers;
  }
}
