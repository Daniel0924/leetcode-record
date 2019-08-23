package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class APerson {

    int age;
    String name;

    public APerson() {
    }

    public APerson(int age, String name) {
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

public class SortTest {

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 8, 2, 1, 7};

        Arrays.sort(nums, (a, b) -> b.compareTo(a));

        List<APerson> list = new ArrayList<>();

        list.add(new APerson(30, "Yang"));

        list.add(new APerson(22, "Dan"));

        list.add(new APerson(28, "Li"));

        list.add(new APerson(88, "sun"));

        list.sort((a, b) -> (a.getAge() - b.getAge()));
        list.forEach((APerson p) -> System.out.println(p.getAge()));
    }
}
