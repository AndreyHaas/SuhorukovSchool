package com.jcourse.gaas.stackcalc.command;

import com.jcourse.gaas.stackcalc.ArgType;
import com.jcourse.gaas.stackcalc.Inject;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Stack;

public class Log implements Command {
    private static Logger LOG = Logger.getRootLogger();

    @Inject(arg = ArgType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute(Stack<Double> stack, Map<String, Double> define, String[] s) {
        if (stack.size() == 0) {
            LOG.error("Error. Stack is empty");
        } else {
            stack.push(StrictMath.log(stack.pop()));
        }
    }
}