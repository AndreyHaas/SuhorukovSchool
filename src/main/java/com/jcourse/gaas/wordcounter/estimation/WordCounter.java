package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class WordCounter implements Comparable<WordCounter> {
    private static Logger log = Logger.getRootLogger();
    private String word;
    private int counter;

    WordCounter(String word) {
        this.word = word;
    }

    void fileWriter() {
        try (PrintWriter writer = new PrintWriter("src/main/resources/output.txt", "UTF-8")) {
            writer.printf("%s, %d, %.2f%n", word, counter);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            log.error(e);
        }
    }

    void plus() {
        counter++;
    }

    @Override
    public int compareTo(WordCounter wordCounter) {
        if (counter < wordCounter.counter) {
            return 1;
        } else if (counter > wordCounter.counter) {
            return -1;
        } else {
            return word.compareTo(wordCounter.word);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCounter counter1 = (WordCounter) o;
        return counter == counter1.counter &&
                Objects.equals(word, counter1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, counter);
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "word='" + word + '\'' +
                ", counter=" + counter +
                '}';
    }
}