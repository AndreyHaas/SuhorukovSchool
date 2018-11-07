package com.jcourse.gaas.firstlession.examples;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//java.lang.*
//java.util.*

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100) + 1; // [1, 100]
        System.out.println(i);

//        InputStream console = System.in;
//        Scanner scanner = new Scanner(console);
//        try {
//            int read = scanner.nextInt();
//            System.out.println("Read int: " + read);
//        } catch (InputMismatchException e) {
//            System.err.println("Incorrect input. Expected: int from 1 to 100");
//            e.printStackTrace();
//        }
//        System.out.println("It's okay");
        String defaultEncoding = System.getProperty("file.encoding");
        System.out.println("encoding: " + defaultEncoding);
        String utf16Str = new String("Hello".getBytes(), Charset.forName("ASCII"));
        System.out.println("ASCII str: " + utf16Str);
        //Throwable -> Exception, Error

        String[] strArray = new String[12];
        Object[] objArray = strArray;
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1.f);
        numbers.add(null);

        //Heap pollution
        //PECS - Producer Extends Consumer Super

        //Effective java Джошуа Блох
    }
}