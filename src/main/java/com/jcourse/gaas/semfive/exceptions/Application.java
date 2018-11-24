package com.jcourse.gaas.semfive.exceptions;

public class Application {
    public static void main(String[] args) {
        ExceptionGenImpl exceptionGen = new ExceptionGenImpl();

        try {
            exceptionGen.generateNullPointerException();
        } catch (NullPointerException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        try {
            exceptionGen.generateClassCastException();
        } catch (ClassCastException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        try {
            exceptionGen.generateOutOfMemoryError();
        } catch (OutOfMemoryError ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        try {
            exceptionGen.generateNumberFormatException();
        } catch (NumberFormatException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        try {
            exceptionGen.generateStackOverflowError();
        } catch (StackOverflowError ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        try {
            exceptionGen.generateMyException("Тут ошибка");
        } catch (MyException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
