package com.jcourse.gaas.wordcounter.estimation;

public class WordCounter {
    private String word;
    private long counter;

    public WordCounter(String word) {
        this.word = word;
    }

    public WordCounter(long counter) {
        this.counter = counter;
    }
}
