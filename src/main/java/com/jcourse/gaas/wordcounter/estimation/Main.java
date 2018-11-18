package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Logger log = Logger.getRootLogger();
    private String word;
    private int count;
    private int frequency;
    private int totalcount;

    public static void main(String[] args) {
        String line;
        try (FileReader fileReader = new FileReader("src/main/resources/input.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            StringBuilder stringBuilder = new StringBuilder();
            line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            log.error(ex);
        }
    }
}
