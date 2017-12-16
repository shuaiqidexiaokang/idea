package com.lzk.beans;

public class HelloWorld {
    private String name;

    HelloWorld() {
        System.out.println("HelloWorld's Constructor");
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public void setName(String name) {

        System.out.println("setName");
        this.name = name;
    }

    public void hello() {
        System.out.println("hello:" + name);
    }
}
