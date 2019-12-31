package demo.qf.spring.jdbctemplate;

import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan
@Configuration
public class JdbcTemplateConfig {
  @Bean
  public DataSource mysqlDatasource() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName(Driver.class.getName());
    config.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
    config.setUsername("akigaze");
    config.setPassword("akigaze");
    config.setMaximumPoolSize(3);
    config.setIdleTimeout(60000);
    return new HikariDataSource(config);
  }

  @Bean
  public JdbcTemplate jdbcTemplate1(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
