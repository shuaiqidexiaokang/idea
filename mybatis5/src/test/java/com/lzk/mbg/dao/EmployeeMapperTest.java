package com.lzk.mbg.dao;

import com.lzk.mbg.entity.Employee;
import com.lzk.mbg.entity.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lzk on 2017/12/24 23:26
 * Description:
 */
public class EmployeeMapperTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testMyBatis3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        //查询所有
        List<Employee> employees = employeeMapper.selectByExample(null);
        employees.forEach(employee ->System.out.println(employee.getId() + ":"+employee.getLastName()));
        //带条件查询
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmailLike("%1%");
        criteria.andGenderEqualTo("1");
        List<Employee> employees1 = employeeMapper.selectByExample(employeeExample);
        employees1.forEach(employee ->System.out.println(employee.getId() + ":"+employee.getLastName()));
    }
}
