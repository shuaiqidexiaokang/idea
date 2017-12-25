package com.lzk.ssm.dao;

import com.lzk.ssm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void getEmpsById() throws Exception {
        Employee employee = employeeDao.queryEmpsById(2);
        System.out.println(employee);
    }

    @Test
    public void queryAll() throws Exception {
        List<Employee> employees = employeeDao.queryAll();
        employees.forEach(System.out::println);
    }

    @Test
    public void insertEmps() throws Exception {
        Employee employee = new Employee(0,"ASA","1","456123");
        int count = employeeDao.insertEmps(employee);
        System.out.println(count);
    }

    @Test
    public void deleteEmpsById() throws Exception {
        int count = employeeDao.deleteEmpsById(10);
        System.out.println(count);
    }

    @Test
    public void updateEmps() throws Exception {
        Employee employee = employeeDao.queryEmpsById(11);
        System.out.println(employee);
        employee.setEmail("12345414");
        int count = employeeDao.updateEmps(employee);
        System.out.println(count);
    }



}