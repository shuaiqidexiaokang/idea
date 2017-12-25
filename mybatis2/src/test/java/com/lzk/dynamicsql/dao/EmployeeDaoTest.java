package com.lzk.dynamicsql.dao;

import com.lzk.dynamicsql.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession(true);

    }
    @Test
    public void getEmpsByConditionIf() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setEmail("1");
            //employee.setLastName("AA");
            List<Employee> employees = employeeDao.getEmpsByConditionIf(employee);
            employees.forEach(System.out::println);//jdk8新特性
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getEmpsByConditionTrim() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setEmail("%1%");
            List<Employee> employees = employeeDao.getEmpsByConditionTrim(employee);
            employees.forEach(System.out::println);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getEmpsByConditionChoose() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            List<Employee> employees = employeeDao.getEmpsByConditionChoose(employee);
            employees.forEach(System.out::println);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void updateEmp() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setId(1);
            employee.setEmail("1234567890");
            employeeDao.updateEmpSet(employee);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void updateEmpTrim() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setId(2);
            employee.setEmail("987654321");
            employee.setGender("1");
            employeeDao.updateEmpTrim(employee);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getEmpsByConditionForEach() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            List<Employee> employees = employeeDao.getEmpsByConditionForEach(Arrays.asList(1,2,3));
            employees.forEach(System.out::println);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void insertEmps() throws Exception {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(0,"QQ","1","78956"));
            employees.add(new Employee(0,"WW","0","78956"));
            employees.add(new Employee(0,"EE","0","4561238"));
            employeeDao.insertEmps(employees);
        }finally{
            sqlSession.close();
        }
    }

}