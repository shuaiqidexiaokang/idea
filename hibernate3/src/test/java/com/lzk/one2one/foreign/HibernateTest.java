package com.lzk.one2one.foreign;

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
        //1. 默认情况下对关联属性使用懒加载
        //2. 所以会出现懒加载异常的问题.
        Department department = (Department) session.get(Department.class,1);
        System.out.println(department.getDepartmentName());
        //3. 查询 Manager 对象的连接条件应该是 dept.manager_id = mgr.manager_id
        //而不应该是 dept.dept_id = mgr.manager_id
        System.out.println(department.getManager().getManagerName());
    }

    @Test
    public void testGet2(){
        //在查询没有外键的实体对象时, 使用的左外连接查询, 一并查询出其关联的对象
        //并已经进行初始化.
        Manager manager = (Manager) session.get(Manager.class, 1);
        System.out.println(manager.getManagerName());
        System.out.println(manager.getDepartment().getDepartmentName());
    }
}
