package com.lzk.dto;

import com.lzk.entity.Department;
import com.lzk.entity.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Created by lzk on 2017/12/29 14:22
 * Description:
 */
@Component
public class EmployeeCoverter implements Converter<String,Employee> {

    @Override
    public Employee convert(String s) {
        if (s!=null){
            String[] vals = s.split("-");
            if (vals !=null&& vals.length==4){
                String lastName = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(vals[3]));
                Employee employee = new Employee(null,lastName,email,gender,department);
                System.out.println(s + " Covert " + employee);
                return employee;
            }
        }
        return null;
    }
}
