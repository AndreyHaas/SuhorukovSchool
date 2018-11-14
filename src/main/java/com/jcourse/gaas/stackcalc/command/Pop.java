package com.jcourse.gaas.stackcalc.command;

import java.util.Map;
import java.util.Stack;

public class Pop implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        stack.pop();
    }

    @Override
    public void execute() {

    }
}
