package com.jcourse.gaas.stackcalc.commands;

import java.util.Map;
import java.util.Stack;

public class Sqrt implements Commands {
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        if (stack.isEmpty()) {
            System.out.println("Error. Stack is empty");
        } else {
            stack.push(Math.sqrt(stack.pop()));
        }
    }
}
