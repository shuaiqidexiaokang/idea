package com.lzk.mapper;

import com.lzk.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mapper.xml")
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void addStudent() throws Exception {
        Student student = new Student("阿猫",5);
        int result = studentMapper.addStudent(student);
        System.out.println(result);
    }

    @Test
    public void deleteStudent() throws Exception {
        int result = studentMapper.deleteStudent(1004);
        System.out.println(result);
    }

    @Test
    public void updateStudent() throws Exception {
        Student student = new Student(1005,"阿猫",5);
        int result = studentMapper.updateStudent(student);
        System.out.println(result);
    }

    @Test
    public void queryStudentById() throws Exception {
        Student student = studentMapper.queryStudentById(1002);
        System.out.println(student);
    }

    @Test
    public void queryStudents() throws Exception {
        List<Student> students = studentMapper.queryStudents();
        students.forEach(System.out::println);
    }

}