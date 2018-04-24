package com.xaut.Employee.entity;

public enum Gender {

    MAN(0, "男"), WOMEN(1, "女");

    private int code;
    private String gender;

    Gender(int code, String gender) {
        this.code = code;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getCode() {
        return code;
    }

}
