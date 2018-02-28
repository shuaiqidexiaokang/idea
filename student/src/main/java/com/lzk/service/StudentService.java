package com.lzk.service;

import com.lzk.model.Student;

import java.util.List;

/**
 * Created by lzk on 2018/2/13 23:08
 * Description:
 */
public interface StudentService {
    int addStudent(Student student);
    int deleteStudent(Integer id);
    int updateStudent(Student student);
    Student queryStudentById(Integer id);
    List<Student> queryStudents();
}
