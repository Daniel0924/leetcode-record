package com.ydh.School;

public class Book {


    public static final String TAG = "420042";

    private String name;
    private String auther;

    public Book() {
    }

    private Book(String name, String auther) {

        this.name = name;
        this.auther = auther;
    }

    @Override
    public String toString() {

        return "book name: " + name + ", auther: " + auther + ".";
    }


    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "declare method 1";
                break;
            case 1:
                string = "declare method 2";
                break;
            default:
                string = "declare method 1";
        }
        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
