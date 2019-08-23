package com.ydh.School;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflactClass {


    public static void getBook() {

        try {
            Class<?> bookClass = Class.forName("com.ydh.School.Book");

            Book book = (Book) bookClass.newInstance();

            book.setName("Harry Potter");
            book.setAuther("Rolin");

            System.out.println(book.toString());

        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }

    public static void getOCnstructorBook() {

        try {
            Class<?> classBook = Class.forName("com.ydh.School.Book");

            Constructor<?> constructor = classBook.getDeclaredConstructor(String.class, String.class);
            constructor.setAccessible(true);
            Book book = (Book) constructor.newInstance("love story", "LiMing");

            System.out.println(book.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getPrivateField() {

        try {
            Class<?> classBook = Class.forName("com.ydh.School.Book");

            Object bookObject = classBook.newInstance();

            Field field = classBook.getDeclaredField("TAG");
            field.setAccessible(true);
            String s = (String) field.get(bookObject);

            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getPrivateMethod() {

        try {
            Class<?> classBook = Class.forName("com.ydh.School.Book");
            Method method = classBook.getDeclaredMethod("declaredMethod", int.class);
            Object object = classBook.newInstance();
            method.setAccessible(true);
            String s = (String) method.invoke(object, 1);

            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        getBook();

        getOCnstructorBook();

        getPrivateField();

        getPrivateMethod();
    }
}
