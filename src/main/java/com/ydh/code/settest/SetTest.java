package com.ydh.code.settest;

class Animals {
    private String name;

    public void say() {
        System.out.println("animal");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Pigs extends Animals {
    private String name;

    @Override
    public void say() {
        System.out.println("pigs");
    }

    public void run() {
        System.out.println("I am running");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SetTest {

    public static void main(String[] args) {
        Animals animals = new Pigs();
        animals.say();
        ((Pigs) animals).run();

        Pigs pigs = (Pigs) animals;
    }
}
