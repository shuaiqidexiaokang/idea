package com.lzk.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    private ApplicationContext applicationContext = null;
    private JdbcTemplate jdbcTemplate = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) applicationContext.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 使用具名参数时，可以使用update(String sql, SqlParameterSource paramSource)方法进行操作
     * 1。SQL语句中的参数与类的属性一致
     * 2。使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数
     */
    @Test
    public void getNamedParameterJdbcTemplate2(){
        String sql = "UPDATE student SET age = :age WHERE id = :id";
        Student student = new Student();
        student.setId(9);
        student.setAge(21);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(student);
        namedParameterJdbcTemplate.update(sql,paramSource);
    }

    /**
     * NamedParameterJdbcTemplate（具名参数）和JdbcTemplate比较
     * 可以为参数起名字
     * 好处：若有多个参数，则不用再去对应位置，直接对应参数，便于维护
     * 缺点：较为烦躁
     */
    @Test
    public void getNamedParameterJdbcTemplate(){
        String sql = "UPDATE student SET age = :age WHERE id = :id";
        Map<String,Object> papamMap = new HashMap<String,Object>();
        papamMap.put("age",30);
        papamMap.put("id",3);
        namedParameterJdbcTemplate.update(sql,papamMap);
    }

    /**
     * 执行批量更新：批量更新的INSERT,UPDATE,DELETE
     * 最后一个参数是Object[]的List类型：因为修改一条记录需要一个Object的数组，那么多条不就需要多个Object的数组么
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO student(name,age,phone) VALUES (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"AA",18,12345678999L});
        batchArgs.add(new Object[]{"BB",21,12345678922L});
        batchArgs.add(new Object[]{"CC",22,12345678911L});
        batchArgs.add(new Object[]{"DD",20,12345678933L});
        batchArgs.add(new Object[]{"EE",22,12345678944L});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /**
     * 获取当个列的值，或做统计查询
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT COUNT(id) FROM student";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    /**
     *查到实体类的集合
     * 注意不是调用queryForList方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id,name,age,phone FROM student WHERE id > ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students = jdbcTemplate.query(sql, rowMapper,1);
        System.out.println(students);
    }

    /**
     * 从数据库中获取一条记录，实际得到一个对象
     * 注意不是调用queryForObject(String sql, Class<Student> requiredType, Object... agrs)方法！
     * 而需要调用queryForObject(String sql, RowMapper<Student> rowMapper, Object... agrs)
     * 1。其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
     * 2。使用SQL中列的别名完成类名和类的属性名的映射。
     * 3.不支持级联属性。jdbcTemplate到底是一个JDBC的小工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id,name,age,phone FROM student WHERE id = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper,1);
        System.out.println(student);
    }

    /**
     * 执行INSERT,UPDATE,DELETE
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE student SET age = ? WHERE id = ?";
        jdbcTemplate.update(sql,17,1);
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
