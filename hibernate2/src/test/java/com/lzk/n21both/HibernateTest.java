package com.lzk.n21both;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        customer.setCustomerName("CUSTOMER-2");
        Order order1 = new Order();
        order1.setOrderName("ORDER-1");
        order1.setCustomer(customer);
        Order order2 = new Order();
        order2.setOrderName("ORDER-2");
        order2.setCustomer(customer);
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        session.save(customer);
        session.save(order1);
        session.save(order2);
    }

    @Test
    public void testMany2OneGet(){
        Customer customer = (Customer) session.get(Customer.class,1);
        System.out.println(customer.getCustomerName());
        System.out.println(customer.getOrders().getClass());
    }

    @Test
    public void testUpdate(){
        Customer customer = (Customer) session.get(Customer.class,1);
        customer.getOrders().iterator().next().setOrderName("AAA");
    }

    @Test
    public void testDelete(){
        Order order = (Order) session.get(Order.class,2);
        session.delete(order);
    }
}
