package com.lzk.other.dao;


import com.lzk.other.entity.Employee;

import java.util.List;

/**
 * Created by lzk on 2017/12/24 17:00
 * Description:ssm
 */

public interface EmployeeDao {
    public List<Employee> queryAll();

    public int insertEmp(Employee employee);

    public List<Employee> queryAllByProcedure();

}
