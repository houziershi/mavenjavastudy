package com.my.concurrent.executorservice;

import com.google.common.base.Objects;

public class Person {
    String name;
    String discription;
    int age;

    public Person(String name, String discription, int age) {
        this.name = name;
        this.discription = discription;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equal(name, person.name) &&
                Objects.equal(discription, person.discription);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, discription, age);
    }
}
