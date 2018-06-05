package com.example.ampq.bean;

import java.io.Serializable;

/**
 * @author BaoZhou
 * @date 2018/6/5
 */
public class testBean implements Serializable {
    String name;
    String age;

    public testBean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public testBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "testBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
