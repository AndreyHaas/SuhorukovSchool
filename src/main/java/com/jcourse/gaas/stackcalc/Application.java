package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.common.FileReader;

public class Application {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        reader.readFile();
    }
}