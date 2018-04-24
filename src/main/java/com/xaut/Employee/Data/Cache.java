package com.xaut.Employee.Data;

import com.xaut.Employee.entity.Employee;
import com.xaut.Employee.entity.Gender;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Cache {

    private static final List<Employee> cache = new ArrayList<>();

    @PostConstruct
    void init() {
        cache.add(new Employee(0, "小明", 20, Gender.MAN));
        cache.add(1, new Employee(1, "小红", 19, Gender.WOMEN));
        cache.add(2, new Employee(2, "小智", 15, Gender.MAN));
        cache.add(3, new Employee(3, "小刚", 16, Gender.MAN));
        cache.add(4, new Employee(4, "小霞", 15, Gender.WOMEN));
    }

    public static List<Employee> getCache() {
        return cache;
    }
}
