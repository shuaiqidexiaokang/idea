package com.lzk.springboot.controller;

import com.lzk.springboot.model.Student;
import com.lzk.springboot.repository.StudentRepository;
import com.lzk.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/1/19 19:20
 * Description:
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生记录
     * @return
     */
    @GetMapping(value = "/students")
    public List<Student> getStudentsList(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    /**
     * 添加一个学生
     * @param age
     * @param name
     * @return
     */
    @PostMapping(value = "/students")
    public Student addStudent(@RequestParam("age") Integer age,@RequestParam("name") String name){
        Student stduent = new Student();
        stduent.setAge(age);
        stduent.setName(name);
        return  studentRepository.save(stduent);
    }

    /**
     * 查询一个学生
     * @param id
     * @return
     */
    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable("id")Integer id){
        return studentRepository.findOne(id);
    }

    /**
     * 更新学生信息
     * @param id
     * @param age
     * @param name
     */
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Integer id,
                              @RequestParam("age") Integer age,
                              @RequestParam("name")String name){
        Student student = new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        return studentRepository.save(student);
    }
    /**
     * 删除指定id的学生
     * @param id
     * @return
     */
    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentRepository.delete(id);
    }

    /**
     * 根据学生年龄查询学生
     * @param age
     * @return
     */
    @GetMapping("students/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable("age") Integer age){
        List<Student> students  = studentRepository.findByAge(age);
        return students;
    }

    @PostMapping("/students/two")
    public void studentTwo(){
        studentService.insertTow();
    }
}

