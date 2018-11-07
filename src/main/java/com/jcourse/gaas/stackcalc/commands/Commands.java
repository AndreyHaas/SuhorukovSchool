package com.jcourse.gaas.stackcalc.commands;

import java.util.Map;
import java.util.Stack;

public interface Commands {
    void execute(Stack<Double> stack, Map<String, Double> define, String[] str);
}
