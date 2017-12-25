package com.lzk.dynamicsql.dao;

import com.lzk.dynamicsql.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lzk on 2017/12/20 16:31
 * Description:动态SQL
 */
public interface EmployeeDao {
    public List<Employee> getEmpsByConditionIf(Employee employee);
    public List<Employee> getEmpsByConditionTrim(Employee employee);
    public List<Employee> getEmpsByConditionChoose(Employee employee);
    public void updateEmpSet(Employee employee);
    public void updateEmpTrim(Employee employee);
    public List<Employee> getEmpsByConditionForEach(@Param("ids") List<Integer> ids);
    public void insertEmps(@Param("employees") List<Employee> employees);
}
