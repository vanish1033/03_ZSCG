package com.bjpowernode.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StudenT {

    private String name;
    private int age;
    private School school;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
