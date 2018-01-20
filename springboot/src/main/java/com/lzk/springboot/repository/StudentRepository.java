package com.lzk.springboot.repository;

import com.lzk.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lzk on 2018/1/19 19:18
 * Description:
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{
    public List<Student> findByAge(Integer age);
}
