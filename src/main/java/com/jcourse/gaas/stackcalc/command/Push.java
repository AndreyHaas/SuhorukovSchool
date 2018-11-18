package com.jcourse.gaas.stackcalc.command;

import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        if (define.containsKey(str[1])) {
            stack.push(define.get(str[1]));
        } else {
            stack.push(Double.valueOf(str[1]));
        }
    }
}
