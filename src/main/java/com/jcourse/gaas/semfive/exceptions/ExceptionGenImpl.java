package com.jcourse.gaas.semfive.exceptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExceptionGenImpl implements ExceptionGenerator {

    @Override
    public void generateNullPointerException() {
        String string = null;
        string.toString();
    }

    @Override
    public void generateClassCastException() {
        ArrayList list = new ArrayList();
        list.add(1);
        String o = (String) list.get(0);
    }

    @Override
    public void generateNumberFormatException() {
        String string = "Hello";
        Integer integer = Integer.parseInt(string);
    }

    @Override
    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError() {
        Array[] arrays = new Array[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
