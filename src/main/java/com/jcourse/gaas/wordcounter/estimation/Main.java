package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class Main {
    private static Logger log = Logger.getRootLogger();

    public static void main(String[] args) {
        Map<String, WordCounter> wordMap = new HashMap<>();

        try (Reader reader = new InputStreamReader(
                new BufferedInputStream(
                        new FileInputStream("src/main/resources/input.txt")))) {

            int readChar;
            StringBuilder builder = new StringBuilder();

            while ((readChar = reader.read()) != -1) {
                if (Character.isLetterOrDigit(readChar)) {
                    builder.append((char) readChar);
                } else {
                    if (builder.length() > 0) {
                        String word = builder.toString();
                        WordCounter wordCounter = wordMap.getOrDefault(word, new WordCounter(word));
                        wordCounter.plus();
                        wordMap.put(word, wordCounter);
                        builder = new StringBuilder();
                    }
                }
            }

            if (builder.length() > 0) {
                String word = builder.toString();
                WordCounter wordCounter = wordMap.getOrDefault(word, new WordCounter(word));
                wordCounter.plus();
                wordMap.put(word, wordCounter);
            }
        } catch (IOException e) {
            log.error(e);
        }

        List<WordCounter> list = new ArrayList<>(wordMap.values());

        Collections.sort(list);

        int totalWords = 0;
        for (int i = 0; i < list.size(); i++) {
            totalWords += i;
        }

        list.forEach(System.out::println);
        for (WordCounter wordCounter : list) {
            fileWriter(wordCounter, totalWords);
        }
    }

    static void fileWriter(WordCounter wordCounter, int totalWords) {
        try (PrintWriter writer = new PrintWriter("src/main/resources/output.txt", "UTF-8")) {
            writer.printf("%s, %d, %f.2", wordCounter.word, wordCounter.counter, wordCounter.counter/totalWords*100);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            log.error(e);
        }
    }
}