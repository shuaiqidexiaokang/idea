package com.lzk.ssm.dao;


import com.lzk.ssm.entity.Employee;

import java.util.List;

/**
 * Created by lzk on 2017/12/24 17:00
 * Description:ssm
 */

public interface EmployeeDao {
    public Employee queryEmpsById(Integer id);

    public List<Employee> queryAll();

    public int insertEmps(Employee employee);

    public int deleteEmpsById(Integer id);

    public int updateEmps(Employee employee);

}
