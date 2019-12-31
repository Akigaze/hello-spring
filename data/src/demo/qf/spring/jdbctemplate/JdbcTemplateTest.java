package demo.qf.spring.jdbctemplate;

import demo.qf.spring.City;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcTemplateTest {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
    JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate1");
    System.out.println("---------- test JdbcTemplate object -----------");
    testJdbcTemplate(jdbcTemplate);
    System.out.println("---------- test query one row -----------");
    testGetOneRow(jdbcTemplate);
    System.out.println("---------- test query multiple row -----------");
    testGetCityList(jdbcTemplate);
    System.out.println("---------- test query property -----------");
    testGetProperty(jdbcTemplate);
    System.out.println("---------- test insert one row -----------");
    testInsertOneRow(jdbcTemplate);
    System.out.println("---------- test batch insert -----------");
    testBatchInsert(jdbcTemplate);
    System.out.println("---------- test update records-----------");
    testUpdateProperty(jdbcTemplate);
    System.out.println("---------- test delete records-----------");
    testDeleteRecords(jdbcTemplate);
    System.out.println("---------- test execute function-----------");
    testExecuteSql(jdbcTemplate);
  }

  private static void testJdbcTemplate(JdbcTemplate jdbcTemplate) {
    System.out.println(jdbcTemplate);
  }

  private static void testGetOneRow(JdbcTemplate jdbcTemplate) {
    String getCityByIdSql = "select * from city where id = ?";
    RowMapper<City> rowMapping = new BeanPropertyRowMapper<>(City.class);
    /*
     * public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
     * 只查询一条记录
     * RowMapper 的一个实现类 new BeanPropertyRowMapper<>(City.class)，直接将查询结果转换成指定类型
     * 该方法不支持级联属性
     * 使用午餐构造方法构造对象
     */
    City city = jdbcTemplate.queryForObject(getCityByIdSql, rowMapping, 1);
    System.out.println(city);
  }

  private static void testGetCityList(JdbcTemplate jdbcTemplate) {
    String getCitiesByCountrySql = "select * from city where country = ?";
    RowMapper<City> rowMapping = new BeanPropertyRowMapper<>(City.class);
    /*
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args)
     * 查询多条记录
     **/
    List<City> cities = jdbcTemplate.query(getCitiesByCountrySql, rowMapping, "China");
    System.out.println(cities);
  }

  private static void testGetProperty(JdbcTemplate jdbcTemplate) {
    String rowCountSql = "select count(*) from city";
    /*
     * 重载 public <T> T queryForObject(String sql, Class<T> requiredType)
     * 获取某一个单一的值，requiredType指定结果的类型
     **/
    Integer count = jdbcTemplate.queryForObject(rowCountSql, Integer.class);
    System.out.println(count);
  }

  private static void testInsertOneRow(JdbcTemplate jdbcTemplate) {
    String insertCitySql = "insert into city(code, name, country, population) value(?, ?, ?, ?)";
    City city = new City("NY", "New York City", "USA", 100000);
    int inserted = jdbcTemplate.update(
      insertCitySql,
      // PreparedStatementSetter 手动实现，类似于使用PreparedStatement设置参数值，防止SQL注入
      new PreparedStatementSetter() {
        @Override
        public void setValues(PreparedStatement preparedStatement) throws SQLException {
          preparedStatement.setString(1, city.getCode());
          preparedStatement.setString(2, city.getName());
          preparedStatement.setString(3, city.getCountry());
          preparedStatement.setInt(4, city.getPopulation());
        }
      });
    System.out.println("insert " + inserted + " rows");
  }

  private static void testBatchInsert(JdbcTemplate jdbcTemplate) {
    String insertCitiesSql = "insert into city(code, name, country, population) values(?, ?, ?, ?)";
    List<City> cities = Arrays.asList(
      new City("LD", "London", "UK", 4000),
      new City("TK", "Tokyo", "Japan", 66000)
    );
    /*
     * public int[] batchUpdate(String sql, List<Object[]> batchArgs)
     * 每一条记录所需要的参数为一个Object数组
     * */
    int[] inserted = jdbcTemplate.batchUpdate(insertCitiesSql, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement preparedStatement, int index) throws SQLException {
        City city = cities.get(index);
        preparedStatement.setString(1, city.getCode());
        preparedStatement.setString(2, city.getName());
        preparedStatement.setString(3, city.getCountry());
        preparedStatement.setInt(4, city.getPopulation());
      }

      // getBatchSize用于指定该批处理的记录总数，作为执行语句的次数
      @Override
      public int getBatchSize() {
        return cities.size();
      }
    });
    System.out.println("insert " + Arrays.stream(inserted).sum() + " rows");
  }

  private static void testUpdateProperty(JdbcTemplate jdbcTemplate) {
    String updateCountrySql = "update city set country = ? where country = ?";
    /*
    直接传入参数
    public int update(String sql, Object... args)
     */
    int updated = jdbcTemplate.update(updateCountrySql, "China", "USA");
    System.out.println("update " + updated + " rows");
  }

  private static void testDeleteRecords(JdbcTemplate jdbcTemplate) {
    String deleteCitySql = "delete from city where population > ?";
    int deleted = jdbcTemplate.update(
      deleteCitySql,
      new PreparedStatementSetter() {
        @Override
        public void setValues(PreparedStatement preparedStatement) throws SQLException {
          preparedStatement.setInt(1, 180000);
        }
      });
    System.out.println("delete " + deleted + " rows");
  }

  private static void testExecuteSql(JdbcTemplate jdbcTemplate) {
    String sql = "select * from city where population < ?";
    List<City> cities = jdbcTemplate.execute(
      new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
          return connection.prepareStatement(sql);
        }
      },
      new PreparedStatementCallback<List<City>>() {
        @Override
        public List<City> doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
          preparedStatement.setInt(1, 100000);
          ResultSet resultSet = preparedStatement.executeQuery();
          List<City> cities = new ArrayList<>();
          while (resultSet.next()) {
            City city = new City();
            city.setId(resultSet.getInt(City.FIELD_ID));
            city.setCode(resultSet.getString(City.FIELD_CODE));
            city.setName(resultSet.getString(City.FIELD_NAME));
            city.setCountry(resultSet.getString(City.FIELD_COUNTRY));
            city.setPopulation(resultSet.getInt(City.FIELD_POPULATION));
            cities.add(city);
          }
          return cities;
        }
      });
    System.out.println(cities);
  }
}
