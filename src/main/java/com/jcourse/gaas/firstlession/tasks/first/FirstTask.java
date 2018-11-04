package com.jcourse.gaas.firstlession.tasks.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstTask {
    private static Logger logger = Logger.getLogger(FirstTask.class.getName());

    public static void main(String[] args) {
        System.out.println(readerViaBufReader());
        System.out.println(readerViaScanner());
    }

    private static String readerViaBufReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = null;

        try {
            inputValue = reader.readLine();
        } catch (IOException ex) {
            logger.log(Level.ALL, "the problem is here ->> ", ex);
        }
        return inputValue;
    }

    private static String readerViaScanner() {
        String inputValue;

        Scanner scanner = new Scanner(System.in);
        inputValue = scanner.nextLine();
        return inputValue;
    }
}