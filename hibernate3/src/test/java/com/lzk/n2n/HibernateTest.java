package com.lzk.n2n;

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
    public void testSave(){
        Category category1 = new Category();
        category1.setName("C-CC");
        Category category2 = new Category();
        category2.setName("C-DD");

        Item item1 = new Item();
        item1.setName("I-CC");
        Item item2 = new Item();
        item2.setName("I-DD");

        category1.getItems().add(item1);
        category1.getItems().add(item2);
        category2.getItems().add(item1);
        category2.getItems().add(item2);

        session.save(category1);
        session.save(category2);
        session.save(item1);
        session.save(item2);
    }

    @Test
    public void testGet(){

    }

    @Test
    public void testGet2(){

    }
}
