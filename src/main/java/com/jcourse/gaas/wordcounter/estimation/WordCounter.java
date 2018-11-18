package com.jcourse.gaas.wordcounter.estimation;

import java.util.Objects;

public class WordCounter implements Comparable<WordCounter> {
    private String word;
    private int counter;

    WordCounter(String word) {
        this.word = word;
    }

    void plus() {
        counter++;
    }

    @Override
    public int compareTo(WordCounter o) {
        return o.counter - counter;
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
}
