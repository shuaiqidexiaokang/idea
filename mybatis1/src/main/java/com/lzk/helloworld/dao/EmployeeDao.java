package com.lzk.helloworld.dao;

import com.lzk.helloworld.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lzk on 2017/12/19 15:00
 * Description:
 */
public interface EmployeeDao {
    public Employee getEmpById(Integer id);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName")String lastName);

    public Employee getEmpByMap(Map<String,Object> map);

    //返回一条记录的map；key就是列名，值就是对应的值
    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //@MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("lastName")
    public Map<String, Employee> getAllMap();

    public List<Employee> getAll();

    public void insert(Employee employee);

    public void delete(@Param("id") Integer id);

    public void update(Employee employee);
}
