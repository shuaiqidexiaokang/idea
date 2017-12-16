package com.lzk.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方式：直接调用某一个类的静态方法就可以返回Bean的实例
 */
public  class StaticCarFactory {
    private static Map<String, Car> cars = new HashMap<String, Car>();

    static{
        cars.put("Audi", new Car("Audi", 30000));
        cars.put("Ford", new Car("Ford", 40000));
    }

    public static Car getCar(String brand){
        return cars.get(brand);
    }
}
