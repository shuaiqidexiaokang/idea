package com.lzk.subclassjoin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


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

    /**
     * 插入操作:
     * 1. 对于子类对象至少需要插入到两张数据表中.
     */
    @Test
    public void testSave(){
        Person person = new Person();
        person.setAge(20);
        person.setName("AA");

        Student student = new Student();
        student.setName("BB");
        student.setAge(18);
        student.setSchool("BBBBB");
        session.save(person);
        session.save(student);
    }

    /**
     * 优点:
     * 1. 不需要使用了辨别者列.
     * 2. 子类独有的字段能添加非空约束.
     * 3. 没有冗余的字段.
     */

    /**
     * 查询:
     * 1. 查询父类记录, 做一个左外连接查询
     * 2. 对于子类记录, 做一个内连接查询.
     */
    @Test
    public void testQuery(){
        List<Person> persons = session.createQuery("FROM Person").list();
        System.out.println(persons.size());

        List<Student> stus = session.createQuery("FROM Student").list();
        System.out.println(stus.size());
    }
}
