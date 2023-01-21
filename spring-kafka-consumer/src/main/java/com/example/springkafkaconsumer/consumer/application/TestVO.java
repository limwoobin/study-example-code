package com.example.springkafkaconsumer.consumer.application;

import lombok.Getter;

@Getter
public class TestVO {
    private String name;
    private Integer age;

//    public TestVO(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "TestVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
