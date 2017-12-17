package com.lzk.hibernate;

import com.lzk.hibernate.dao.BookShopDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


public class SprigHibernateTest {
    private ApplicationContext applicationContext = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    }
    @Test
    public void testDataSource() throws SQLException{
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection ());

    }
}
