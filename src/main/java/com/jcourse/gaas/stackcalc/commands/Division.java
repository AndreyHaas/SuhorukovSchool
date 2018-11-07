package com.jcourse.gaas.stackcalc.commands;

import java.util.Map;
import java.util.Stack;

public class Division implements Commands {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        if (stack.isEmpty()) {
            System.out.println("Error. Stack is empty");
        } else if (stack.size() == 1) {
            System.out.println("Error. Stack contains one item");
        } else {
            stack.push(stack.pop() / stack.pop());
        }
    }
}
