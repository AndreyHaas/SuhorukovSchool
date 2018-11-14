package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.command.Command;

import java.util.List;

public class Calculator {
    private Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public void calculate() {
        List<Command> commands = parser.getCommands();
        for (Command command : commands) {
            command.execute();
        }
    }
}
