package com.lzk.entities;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
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

    //基于？的查询
    @Test
    public void testHQL(){
        String hql = "FROM Employee e WHERE e.salary > ? and e.email like ? order by  e.salary";
        Query query = session.createQuery(hql);
        query.setFloat(0,2000).setString(1,"%1%");
        List<Employee> employees = (List) query.list();
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    //基于:的查询
    @Test
    public void testHQLNamedParameter(){
        String hql = "FROM Employee e WHERE e.salary > :sal AND e.email LIKE :email";
        Query query = session.createQuery(hql);
        query.setFloat("sal", 2000).setString("email", "%1%");
        List<Employee> employees = (List) query.list();
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

    //分页查询
    @Test
    public void testPageQuery() {
        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        int pageNo = 2;
        int pageSize = 5;
        List<Employee> employees = query
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize).list();
        System.out.println(employees);
    }

    @Test
    public void testNameQuery() {
        Query query = session.getNamedQuery("salaryEmployee");
        query.setFloat("minSalary",1500);
        query.setFloat("maxSalary",2500);
        List<Employee> employees = query.list();
        System.out.println(employees);
    }

    @Test
    public void testFieldQuery() {
        String hql = "select e.email,e.salary,e.department FROM Employee e where e.department = :department";
        Query query = session.createQuery(hql);
        Department department = new Department();
        department.setId(2);
        List<Object[]> objects = query.setEntity("department", department).list();
        for(Object[] obj:objects){
            System.out.println(Arrays.asList(obj));
        }
    }

    @Test
    public void testFieldQuery2() {
        String hql = "select new Employee(e.salary,e.email,e.department) FROM Employee e where e.department = :department";
        Query query = session.createQuery(hql);
        Department department = new Department();
        department.setId(2);
        List<Employee> employees = query.setEntity("department", department).list();
        for(Employee employee:employees){
            System.out.println(employee.getSalary()+ ":" +employee.getEmail()+ ":" +employee.getDepartment());
        }
    }

    @Test
    public void testGroupBy() {
        String hql = "select min(e.salary),max(e.salary) FROM Employee e group by e.department having min(e.salary) > :minSalary";
        Query query = session.createQuery(hql);
        List<Object[]> objects = query.setFloat("minSalary", 2000).list();
        for(Object[] obj:objects){
            System.out.println(Arrays.asList(obj));
        }
    }

    @Test
    public void testLeftJoinFetch(){
		//String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.emps";
        String hql = "FROM Department d INNER JOIN FETCH d.employees";
        Query query = session.createQuery(hql);

        List<Department> departments = query.list();
        departments = new ArrayList<Department>(new LinkedHashSet(departments));
        System.out.println(departments.size());
        for(Department department: departments){
            System.out.println(department.getName() + "-" + department.getEmployees().size());
        }
    }

    @Test
    public void testLeftJoin(){
        String hql = "SELECT DISTINCT d FROM Department d LEFT JOIN d.employees";
        Query query = session.createQuery(hql);
        List<Department> departments = query.list();
        System.out.println(departments.size());
        for(Department department: departments){
            System.out.println(department.getName() + "-" + department.getEmployees().size());
        }
    }

    @Test
    public void testLeftJoinFetch2(){
        String hql = "SELECT e FROM Employee e INNER JOIN e.department";
        Query query = session.createQuery(hql);
        List<Employee> employees = query.list();
        System.out.println(employees.size());
        for(Employee employee: employees){
            System.out.println(employee.getName() + ", " + employee.getDepartment().getName());
        }
    }

    @Test
    public void testQBC(){
        //1. 创建一个 Criteria 对象
        Criteria criteria = session.createCriteria(Employee.class);
        //2. 添加查询条件: 在 QBC 中查询条件使用 Criterion 来表示
        //Criterion 可以通过 Restrictions 的静态方法得到
        criteria.add(Restrictions.eq("email", "1111"));
        criteria.add(Restrictions.gt("salary", 500F));
        //3. 执行查询
        Employee employee = (Employee) criteria.uniqueResult();
        System.out.println(employee);
    }

    @Test
    public void testQBC2(){
        Criteria criteria = session.createCriteria(Employee.class);
        //1. AND: 使用 Conjunction 表示
        //Conjunction 本身就是一个 Criterion 对象
        //且其中还可以添加 Criterion 对象
        Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(Restrictions.like("email", "1", MatchMode.ANYWHERE));
        Department department = new Department();
        department.setId(4);
        conjunction.add(Restrictions.eq("department", department));
        System.out.println(conjunction);
        //2. OR
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.ge("salary", 3000F));
        disjunction.add(Restrictions.isNull("email"));
        System.out.println(disjunction);
        criteria.add(disjunction);
        criteria.add(conjunction);
        criteria.list();
    }

    @Test
    public void testQBC3(){
        Criteria criteria = session.createCriteria(Employee.class);
        //统计查询: 使用 Projection 来表示: 可以由 Projections 的静态方法得到
        criteria.setProjection(Projections.max("salary"));
        System.out.println(criteria.uniqueResult());
    }

    @Test
    public void testQBC4(){
        Criteria criteria = session.createCriteria(Employee.class);
        //1. 添加排序
        criteria.addOrder(Order.asc("salary"));
        criteria.addOrder(Order.desc("email"));
        //2. 添加翻页方法
        int pageSize = 5;
        int pageNo = 3;
        criteria.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Test
    public void testNativeSQL(){
        String sql = "INSERT INTO Departments VALUES(?, ?)";
        Query query = session.createSQLQuery(sql);
        query.setInteger(0, 10)
                .setString(1, "ATGUIGU")
                .executeUpdate();
    }

    @Test
    public void testHQLUpdate(){
        String hql = "DELETE FROM Department d WHERE d.id = :id";
        session.createQuery(hql).setInteger("id", 10)
                .executeUpdate();
    }

    //类二级缓存
    @Test
    public void testHibernateSecondLevelCache(){
        Employee employee = (Employee) session.get(Employee.class, 1);
        System.out.println(employee.getName());

        transaction.commit();
        session.close();

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Employee employee2 = (Employee) session.get(Employee.class, 1);
        System.out.println(employee2.getName());
    }

    //集合二级缓存
    @Test
    public void testCollectionSecondLevelCache(){
        Department department = (Department) session.get(Department.class, 2);
        System.out.println(department.getName());
        System.out.println(department.getEmployees().size());

        transaction.commit();
        session.close();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Department department2 = (Department) session.get(Department.class, 2);
        System.out.println(department2.getName());
        System.out.println(department2.getEmployees().size());
    }

    //查询缓存
    @Test
    public void testQueryCache(){
        Query query = session.createQuery("FROM Employee");
        query.setCacheable(true);

        List<Employee> employees = query.list();
        System.out.println(employees.size());

        employees = query.list();
        System.out.println(employees.size());

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setCacheable(true);
    }

}
