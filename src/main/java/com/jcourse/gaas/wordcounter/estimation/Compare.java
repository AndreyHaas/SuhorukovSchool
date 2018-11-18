package com.jcourse.gaas.wordcounter.estimation;

public class Compare implements Comparable<WordCounter> {

    @Override
    public int compareTo(WordCounter o) {
        if (this.equals(o)) {
            return 0;
        } else if (!(this.equals(o))) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
