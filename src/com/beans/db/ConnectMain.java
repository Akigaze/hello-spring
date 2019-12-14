package com.beans.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ConnectMain {
  public static void main(String[] args) throws SQLException {
    ApplicationContext context = new ClassPathXmlApplicationContext("db-connect.xml");
    DataSource dataSource = (DataSource) context.getBean("data-source");
    System.out.println(dataSource.getConnection());
  }
}
