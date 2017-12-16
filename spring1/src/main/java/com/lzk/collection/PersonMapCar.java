package com.lzk.collection;

import java.util.Map;

public class PersonMapCar {
    private String name;
    private int age;
    private Map<String,Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCar() {
        return cars;
    }

    public void setCar(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "PersonMapCar{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + cars +
                '}';
    }

    public void setCars(Map cars) {
        this.cars = cars;
    }

    public Map getCars() {
        return cars;
    }
}
