package com.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
/*
@PropertySource 将properties文件加载到配置文件中
@Value 使用 "${property}" 的占位符获取文件中的属性值
@PropertySource 只能添加在 @Configuration注解的类上

从JDK1.8开始，允许使用多个@PropertySource 加载多个资源文件
也可以用 @PropertySources (JDK1.8之前)

*/
//@PropertySources({
//  @PropertySource("classpath:com/value/resource/school-information.properties"),
//  @PropertySource("classpath:com/value/resource/student-information.properties")
//})
@PropertySource("classpath:com/value/resource/school-information.properties")
@PropertySource("classpath:com/value/resource/student-information.properties")
public class PropertyValueConfig {
  @Bean
  public List<Integer> grades(@Value("${grade.min}") Integer min, @Value("${grade.max}") Integer max) {
    List<Integer> _grades = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      _grades.add(i);
    }
    return _grades;
  }

  /*
  @Value 可以直接对property使用逗号分隔字符字符串生成数组或列表
  */
  @Bean
  public List<String> teachers(@Value("${teacher}") List<String> _teachers) {
    return _teachers;
  }

  @Bean
  public boolean isNational(@Value("${type.national}") boolean national) {
    return national;
  }

  @Bean
  /*
    结合SpEL表达式，将map格式的字符串转成Map对象
    #{expression} 转换获取变量
  */
  public Map<String, Integer> duty(@Value("#{${duty.teacher}}") Map<String, Integer> teacherDuty){
    return teacherDuty;
  }

  @Bean
  public int studentTotal(@Value("${student.total}") int total) {
    return total;
  }


  /*
    当要引用的资源属性不存在时，@Value会被这个字符串作为值
  */
  @Bean
  public Object unknownValue(@Value("${unknown.param}") Object value){
    return value;
  }

  /*
    使用 ":" 给资源属性设置默认值，当资源属性不存在时，则使用默认值
  */
  @Bean
  public Object valueWithDefault(@Value("${unknown.param:some default}") Object value){
    return value;
  }
}
