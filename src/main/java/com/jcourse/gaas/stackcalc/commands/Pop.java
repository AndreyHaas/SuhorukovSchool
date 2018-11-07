package com.jcourse.gaas.stackcalc.commands;

import java.util.Map;
import java.util.Stack;

public class Pop implements Commands {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        stack.pop();
    }
}
