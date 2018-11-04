package com.jcourse.gaas.firstlession.examples;

class Student {
    int age;
    float weight;

    Student(int age, float weight) {
        this.age = age;
        this.weight = weight;
    }
}

public class Main {
    //camelCase variables, methods)
    //MyClass - Pascal case (classes, interfaces, enums)

    private static final String MY_STRING_CONST = "Hello";

    private static String greetUser(String user) {
        return MY_STRING_CONST + ", " + user;
    }

    public static void main(String[] args) {
        String greet = greetUser("Andreas");
        System.out.println(greet);
        Student student = new Student(23, 86f);
        student.weight += 1;
        System.out.println("Student age: " + student.age);
        System.out.println("Student weight: " + student.weight);
        int max = Math.max(32, 34);
        System.out.println(max);
    }

    static void swap(int aa, int bb) {
        int tmp = aa;
        aa = bb;
        bb = tmp;
        System.out.println("aa: " + aa);
        System.out.println("bb: " + bb);
    }

    static void incraseAge(Student studentParam) {
        studentParam.age += 5;
    }
}