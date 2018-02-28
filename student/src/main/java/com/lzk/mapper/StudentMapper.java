package com.lzk.mapper;

import com.lzk.model.Student;

import java.util.List;

/**
 * Created by lzk on 2018/2/13 21:26
 * Description:
 */
public interface StudentMapper {
    int addStudent(Student student);
    int deleteStudent(Integer id);
    int updateStudent(Student student);
    Student queryStudentById(Integer id);
    List<Student> queryStudents();
}
