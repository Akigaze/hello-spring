package importconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
/*
@Import 注解可以合并多个Java配置类(带@Configuration) 放到一个统一的入口
相当于xml配置的import标签
*/
@Import({TrainConfig.class, AirplaneConfig.class})
public class ApplicationConfig {

}
