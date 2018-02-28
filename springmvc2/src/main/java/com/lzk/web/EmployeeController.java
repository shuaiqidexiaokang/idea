package com.lzk.web;

import com.lzk.dao.DepartmentDao;
import com.lzk.dao.EmployeeDao;
import com.lzk.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lzk on 2017/12/28 20:16
 * Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有emps
     * @param map
     * @return
     */
    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "list";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    /**
     * 添加emp
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除指定emp
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    @ResponseBody()
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",employeeDao.get(id));
        return "input";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    @ResponseBody()
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,
                            Map<String,Object> map){
        if(id !=null){
            map.put("employee",employeeDao.get(id));
        }
    }

/*    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("lastName");
    }*/
}
