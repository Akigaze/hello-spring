package com.beans.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class DataSource {
    private Properties dbProps;

    public Properties getDbProps() {
        return dbProps;
    }

    public void setDbProps(Properties dbProps) {
        this.dbProps = dbProps;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "dbProps=" + dbProps +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource mysqlConn = (DataSource) context.getBean("mysql-config");
        System.out.println(mysqlConn);
    }
}
