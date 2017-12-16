package com.lzk.annotation.repository;

import com.lzk.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    //IOC容器中没有装配bean，则可以使用required = false，允许属性不被设置
    @Autowired(required = false)
    private TestObject testObject;
    @Override
    public void save() {
        System.out.println("UserRepository Save...");
    }
}
