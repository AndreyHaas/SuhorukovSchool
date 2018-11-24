package com.jcourse.gaas.wordcounter.estimation;

import org.apache.log4j.Logger;

import java.util.Objects;

public class WordCounter implements Comparable<WordCounter> {
    private static Logger log = Logger.getRootLogger();
    protected String word;
    protected int counter;

    WordCounter(String word) {
        this.word = word;
    }

    public WordCounter() {

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