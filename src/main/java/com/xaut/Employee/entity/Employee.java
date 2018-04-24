package com.xaut.Employee.entity;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private int age;
    private Gender gender;

    public Employee() {
    }

    public Employee(int id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender.getGender();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return id == e.id && age == e.age
                && Objects.equals(name, e.name)
                && Objects.equals(gender, e.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender);
    }
}
