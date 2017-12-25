package com.lzk.other.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzk.other.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new  SqlSessionFactoryBuilder().build(inputStream);
    }

    //分页操作
    @Test
    public void queryAll() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Page<Object> page = PageHelper.startPage(2,3);
            List<Employee> employees = employeeDao.queryAll();
            PageInfo<Employee> pageInfo = new PageInfo<>(employees);
            employees.forEach(System.out::println);
            System.out.println("当前页码：" + page.getPageNum());
            System.out.println("总记录数：" + page.getTotal());
            System.out.println("每页的记录数：" + page.getPageSize());
            System.out.println("总页码：" + page.getPages());
            System.out.println("---------------------------------------------------");
            System.out.println("当前页码：" + pageInfo.getPageNum());
            System.out.println("总记录数：" + pageInfo.getTotal());
            System.out.println("每页的记录数：" + pageInfo.getPageSize());
            System.out.println("总页码：" + pageInfo.getPages());
            System.out.println("是否第一页：" + pageInfo.isIsFirstPage());
        } finally {
            sqlSession.close();
        }
    }

    //批量操作
    @Test
    public void insertEmp() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            for(int i = 0;i < 100; i++){
                employeeDao.insertEmp(new Employee(0,"WQE","1","165412123"));
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryAllByProcedure() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            List<Employee> employees = employeeDao.queryAllByProcedure();
            employees.forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

}