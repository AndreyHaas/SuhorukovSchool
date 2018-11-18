package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.io.*;

public class Main {
    private static Logger log = Logger.getRootLogger();

    public static void main(String[] args) {
        try (Reader reader = new InputStreamReader(
                new BufferedInputStream(
                        new FileInputStream("src/main/resources/input.txt")))) {

            char[] chars = new char[1];
            int wordCount = reader.read(chars);
            while (wordCount != 0) {
                wordCount++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.charAt(wordCount);
            System.out.println(stringBuilder  );
        } catch (IOException e) {
            log.error(e);
        }
    }
}
