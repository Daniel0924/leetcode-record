package com.ydh.leetcode.March;


class Person {

    int age;
    String name;

    public void say() {
        System.out.println("My name is : " + name + ", I am "
                + age + " years old");
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ReflectTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass =
                    Class.forName("com.ydh.leetcode.March.Person");

            Object object = aClass.newInstance();

            Person person = (Person) object;
            person.setAge(12);
            person.setName("Daniel");

            person.say();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
