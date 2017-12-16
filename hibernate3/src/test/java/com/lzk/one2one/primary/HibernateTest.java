package com.lzk.one2one.primary;

import com.lzk.one2one.primary.Department;
import com.lzk.one2one.primary.Manager;
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
        Department department = new Department();
        department.setDepartmentName("DEPARTMENT-1");
        Manager manager = new Manager();
        manager.setManagerName("MANAGER-1");
        department.setManager(manager);
        manager.setDepartment(department);
        session.save(manager);
        session.save(department);
    }

    @Test
    public void testGet(){
        Department department = (Department) session.get(Department.class,1);
        System.out.println(department.getDepartmentName());
        System.out.println(department.getManager().getManagerName());
    }

    @Test
    public void testGet2(){
        Manager manager = (Manager) session.get(Manager.class, 1);
        System.out.println(manager.getManagerName());
        System.out.println(manager.getDepartment().getDepartmentName());
    }
}
