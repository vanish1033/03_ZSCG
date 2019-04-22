package com.bjpowernode.bean;

import javax.validation.constraints.*;

public class User {

    @NotEmpty(message = "名字不能为空")
    @NotNull(message = "名字不能为null")
    @Size(max = 20,min = 1,message = "名字长度为{min}-{max}之间")
    private String name;


    @Min(value = 0,message = "年龄不能小于{value}")
    @Max(value = 130,message = "年龄不能大于{value}")
    private int age;

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
}
