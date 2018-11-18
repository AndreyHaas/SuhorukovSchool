package com.jcourse.gaas.stackcalc.command;

import com.jcourse.gaas.stackcalc.ArgType;
import com.jcourse.gaas.stackcalc.Inject;

import java.util.Map;
import java.util.Stack;

public class Define implements Command {

    @Inject(arg = ArgType.STACK)
    private Stack<Double> stack;

    public void execute(Stack<Double> stack, Map<String, Double> define, String[] str) {
        define.put(str[1], Double.valueOf(str[2]));
    }
}