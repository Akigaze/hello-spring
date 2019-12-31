package demo.qf.spring.ioc.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectMain {
  public static void main(String[] args) throws SQLException {
    String configLocation = "demo/qf/spring/ioc/db/dbApplicationContext.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

    DataSource dataSource = (DataSource) context.getBean("data-source");
    Connection connection = dataSource.getConnection();
    System.out.println(connection);

    PreparedStatement statement = connection.prepareStatement("select * from city");
    statement.execute();
    ResultSet resultSet = statement.getResultSet();
    List<City> cities = new ArrayList<>();
    while (resultSet.next()){
      int id = resultSet.getInt("id");
      String code = resultSet.getString("code");
      String name = resultSet.getString("name");
      String country = resultSet.getString("country");
      int population = resultSet.getInt("population");
      cities.add(new City(id, code, name, country, population));
    }
    connection.close();

    System.out.println(cities);
  }

}

