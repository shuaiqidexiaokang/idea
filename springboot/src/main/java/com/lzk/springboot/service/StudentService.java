package com.lzk.springboot.service;

import com.lzk.springboot.model.Student;
import com.lzk.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lzk on 2018/1/19 20:53
 * Description:
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void insertTow(){
        Student student1 = new Student();
        student1.setName("QQ");
        student1.setAge(11);
        studentRepository.save(student1);
        Student student2 = new Student();
        student2.setName("ZZZZZZZZZ");
        student2.setAge(22);
        studentRepository.save(student2);

    }

}
