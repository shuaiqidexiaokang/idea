package com.lzk.annotation;

import com.lzk.annotation.controller.UserController;
import com.lzk.annotation.repository.UserRepository;
import com.lzk.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans-annotation.xml");
        TestObject testObject = (TestObject) applicationContext.getBean("testObject");
        System.out.println(testObject);

        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        System.out.println(userRepository);

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);

        UserController userController = (UserController) applicationContext.getBean("userController");
        System.out.println(userController);
        userController.execute();

    }

}
