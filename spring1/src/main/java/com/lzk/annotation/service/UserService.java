package com.lzk.annotation.service;

import com.lzk.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @Qualifier("userJdbcRepository")
    //若bean不唯一，可以使用@Qualifier("userRepositoryImpl")指定bean的名称
    private UserRepository userRepository;
    public void add(){
        System.out.println("UserService add..");
        userRepository.save();
    }
}
