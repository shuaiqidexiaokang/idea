package com.lzk.cache.dao;


import com.lzk.cache.entity.Employee;

import java.util.List;

/**
 * Created by lzk on 2017/12/20 16:31
 * Description:动态SQL
 */
public interface EmployeeDao {
    public Employee getEmpsById(Integer id);
}
