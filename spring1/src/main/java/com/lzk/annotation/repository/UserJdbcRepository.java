package com.lzk.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserJdbcRepository sava..");
    }
}
