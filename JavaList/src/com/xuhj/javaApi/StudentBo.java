package com.xuhj.javaApi;

import java.io.Serializable;
import java.util.Objects;

public class StudentBo implements Serializable {
    private String name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentBo)) return false;
        StudentBo studentBo = (StudentBo) o;
        return age == studentBo.age &&
                Objects.equals(name, studentBo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public StudentBo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
