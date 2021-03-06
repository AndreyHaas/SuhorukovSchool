package com.jcourse.gaas.stackcalc.command;

import com.jcourse.gaas.stackcalc.ArgType;
import com.jcourse.gaas.stackcalc.Inject;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Stack;

public class Addition implements Command {
    private static Logger LOG = Logger.getRootLogger();

    @Inject(arg = ArgType.STACK)
    private Stack<Double> stack;

    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        if (stack.isEmpty()) {
            LOG.error("Error. Stack is empty");
        } else if (stack.size() == 1) {
            LOG.error("Error. Stack contains one item");
        } else {
            stack.push(stack.pop() + stack.pop());
        }
    }
}
