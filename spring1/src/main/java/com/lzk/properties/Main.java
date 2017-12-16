package com.lzk.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-properties.xml");
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");        ;
        System.out.println(dataSource.getConnection());
    }
}
