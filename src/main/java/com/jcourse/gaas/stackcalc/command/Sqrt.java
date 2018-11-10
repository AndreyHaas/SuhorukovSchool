package com.jcourse.gaas.stackcalc.command;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Stack;

public class Sqrt implements Command {
    private static Logger log = Logger.getRootLogger();
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        if (stack.isEmpty()) {
            log.error("Error. Stack is empty");
        } else {
            stack.push(Math.sqrt(stack.pop()));
        }
    }
}
