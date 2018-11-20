package com.jcourse.gaas.semfive.exceptions;

public class MyException extends Exception {
    private int errorCode;

    public MyException(String message) {
        this(0, message);
    }

    private MyException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}