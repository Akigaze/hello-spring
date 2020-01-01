package demo.qf.spring.namedjdbctemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLFeatureNotSupportedException;

@ComponentScan
@Configuration
public class NameJdbcTemplateConfig {

  @Bean
  public ComboPooledDataSource c3p0Datasource() throws PropertyVetoException, SQLFeatureNotSupportedException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql:///test?serverTimezone=UTC");
    dataSource.setUser("akigaze");
    dataSource.setPassword("akigaze");
    dataSource.setMaxPoolSize(5);
    dataSource.setInitialPoolSize(3);
    return dataSource;
  }

  @Bean
  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }
}
