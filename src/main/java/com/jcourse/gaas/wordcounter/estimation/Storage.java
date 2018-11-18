package com.jcourse.gaas.wordcounter.estimation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Storage {
    private Map<String, WordCounter> storage = new HashMap<>();

    void put(String word) {
        WordCounter counter = storage.get(word);
        if (counter == null) {
            counter = new WordCounter(word);
            storage.put(word, counter);
        }
        counter.plus();
    }

    public List<WordCounter> getAll() {
        return new LinkedList<>(storage.values());
    }
}