package com.ydh.leetcode.December;


import java.util.Optional;

class Person {

    private String name;
    private int age;

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class OptionTest {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.getName());

        System.out.println(person.getCar());
    }

}
