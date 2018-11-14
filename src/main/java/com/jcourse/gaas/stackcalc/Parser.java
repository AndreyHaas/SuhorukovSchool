package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.command.Command;

import java.util.List;

public interface Parser {

    List<Command> getCommands();
}
