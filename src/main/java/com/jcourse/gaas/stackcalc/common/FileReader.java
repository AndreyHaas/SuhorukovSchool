package com.jcourse.gaas.stackcalc.common;

import com.jcourse.gaas.stackcalc.command.*;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class FileReader {
    private static Logger LOG = Logger.getRootLogger();

    public void readFile() {
        Map<String, Double> variableMap = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        String s;
        Scanner scanner = null;
        String fileName = "src/main/resources/source.txt";


        try {
            scanner = new Scanner(new FileInputStream(fileName));
        } catch (
                FileNotFoundException ex) {
            LOG.error(ex);
        }

        if (scanner != null) {
            while (scanner.hasNext()) {
                s = scanner.nextLine();
                String[] str = s.split(" ");

                Map<String, Command> commandsMap = new HashMap<>();
                commandsMap.put("push", new Push());
                commandsMap.put("print", new Print());
                commandsMap.put("pop", new Pop());
                commandsMap.put("add", new Addition());
                commandsMap.put("define", new Define());
                commandsMap.put("div", new Division());
                commandsMap.put("sqrt", new Sqrt());
                commandsMap.put("multi", new Multiplication());
                commandsMap.put("sub", new Subtraction());

                if (commandsMap.containsKey(str[0])) {
                    try {
                        commandsMap.get(str[0]).execute(stack, variableMap, str);
                    } catch (NumberFormatException ex) {
                        LOG.error(ex);
                    }
                } else {
                    LOG.error("Unregistered command in commandsMap");
                }
            }
        }
    }
}