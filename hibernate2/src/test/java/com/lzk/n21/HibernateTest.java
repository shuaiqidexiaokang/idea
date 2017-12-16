package com.lzk.n21;

import com.lzk.entities.News;
import com.lzk.entities.Pay;
import com.lzk.entities.Worker;
import com.mchange.net.SocketUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class HibernateTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){
        sessionFactory = null;
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testMany2OneSave(){
        Customer customer = new Customer();
        customer.setCustomerName("CUSTOMER-1");
        Order order1 = new Order();
        order1.setOrderName("ORDER-1");
        order1.setCustomer(customer);
        Order order2 = new Order();
        order2.setOrderName("ORDER-2");
        order2.setCustomer(customer);
        session.save(customer);
        session.save(order1);
        session.save(order2);
    }

    @Test
    public void testMany2OneGet(){
        Order order = (Order) session.get(Order.class,1);
        System.out.println(order.getOrderName());
        System.out.println(order);
        System.out.println(order.getCustomer());
    }

    @Test
    public void testUpdate(){
        Order order = (Order) session.get(Order.class,1);
        order.getCustomer().setCustomerName("CUSTOMER-2");
    }

    @Test
    public void testDelete(){
        Order order = (Order) session.get(Order.class,3);
        session.delete(order);
    }
}
