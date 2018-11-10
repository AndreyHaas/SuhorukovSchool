package com.jcourse.gaas.stackcalc.command;

import java.util.Map;
import java.util.Stack;

public class Define implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        define.put(str[1], Double.valueOf(str[2]));
    }
}
