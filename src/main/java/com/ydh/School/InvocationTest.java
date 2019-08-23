package com.ydh.School;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交了50元");
    }
}

class StudentProxy implements Person {

    Student student;

    public StudentProxy(Person student) {
        this.student = (Student) student;
    }

    @Override
    public void giveMoney() {
        System.out.println("代理同学缴费");
        student.giveMoney();
    }
}

class StudentInvocationHandler<T> implements InvocationHandler {
    T target;

    public StudentInvocationHandler(T target) {
        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");

        MonitorUtil.start();

        Object result = method.invoke(target, args);

        MonitorUtil.finish(method.getName());
        return result;
    }
}

class MonitorUtil {
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start() {

        t1.set(System.currentTimeMillis());
    }

    public static void finish(String methodName) {
        long finishTIme = System.currentTimeMillis();
        System.out.println(methodName + " 方法耗时：" +
                (finishTIme - t1.get()) + "ms");
    }

}

public class InvocationTest {

    public static void main(String[] args) {

        Student zhangsan = new Student("张三");
        StudentProxy proxy = new StudentProxy(zhangsan);

        proxy.giveMoney();

        InvocationHandler stuHandler = new StudentInvocationHandler<Person>(zhangsan);

        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class}, stuHandler);

        stuProxy.giveMoney();


    }


}


