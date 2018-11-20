package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.io.*;

public class Application extends WordCounter {
    private static Logger log = Logger.getRootLogger();
    private String word;
    private int counter;

    void fileReader() {
        Reader reader = null;
        try {
            reader = new InputStreamReader(
                    new BufferedInputStream(
                            new FileInputStream("src/main/resources/input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    void fileWriter() {
        try (PrintWriter writer = new PrintWriter("src/main/resources/output.txt", "UTF-8")) {
//            writer.printf("%s, %d, %.2f%n", word, counter, frequency);
            writer.printf("%s, %d", word, counter);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            log.error(e);
        }
    }
}
