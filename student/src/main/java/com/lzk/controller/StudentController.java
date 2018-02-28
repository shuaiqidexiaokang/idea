package com.lzk.controller;

import com.lzk.model.Student;
import com.lzk.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * Created by lzk on 2018/2/13 23:12
 * Description:
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Student> queryStudents() {
        List<Student> students = studentService.queryStudents();
        return students;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id,Model model) {
        if (id != null) {
            Student student = studentService.queryStudentById(id);
            model.addAttribute("student",student);
        }
        return "save";
    }

    @RequestMapping(value = "/findAllStudent",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Student> findAllStudent() {
        List<Student> students = studentService.queryStudents();
        return students;
    }
}
