package com.lzk.helloworld.dao;

import com.lzk.helloworld.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoTest {
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //1、获取SqlSessionFactory的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2、获取SqlSession的实例
        //return sqlSessionFactory.openSession();//手动提交
        return sqlSessionFactory.openSession(true);//自动提交

    }

    @Test
    public void getEmpById() throws IOException {
        getSqlSession().selectOne()
        SqlSession sqlSession = getSqlSession();
        try{
            //3、获取接口的实现类对象
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.getEmpById(2);
            System.out.println(employee);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getEmpByIdAndLastName() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = employeeDao.getEmpByIdAndLastName(2,"AA");
            System.out.println(employee);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getEmpByMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Map<String,Object> map = new HashMap<>();
            map.put("id",2);
            map.put("lastName","AA");
            Employee employee = employeeDao.getEmpByMap(map);
            System.out.println(employee);
        }finally{
            sqlSession.close();
        }
    }


    @Test
    public void getEmpByIdReturnMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Map<String,Object> map = employeeDao.getEmpByIdReturnMap(2);
            System.out.println(map);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getAllMap() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Map<String, Employee> map= employeeDao.getAllMap();
            System.out.println(map);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void getAll() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            List<Employee> employees = employeeDao.getAll();
            for(Employee employee : employees) {
                System.out.println(employee);
            }
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void insert() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee("BB","1","88888888");
            employeeDao.insert(employee);
            System.out.println(employee);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void delete() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            employeeDao.delete(8);
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void update() throws IOException {
        SqlSession sqlSession = getSqlSession();
        try{
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(7,"CC","2","666666");
            employeeDao.update(employee);
        }finally{
            sqlSession.close();
        }
    }

}