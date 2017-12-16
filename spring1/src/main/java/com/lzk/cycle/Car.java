package com.lzk.cycle;

public class Car {
    private String brand;

    public Car() {
        System.out.println("Car's Constructor...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public String getBrand() {
        System.out.println("getBrand...");
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("setBrand...");
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
