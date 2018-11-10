package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.commands.*;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Application {
    private static Logger log = Logger.getRootLogger();
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<Double>();
        Scanner scanner = null;

        if (args.length > 0) {
            try {
                scanner = new Scanner(new FileInputStream(args[0]));
            } catch (FileNotFoundException ex) {
                log.error(ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }

        Map<String, Commands> commandsMap = new HashMap<String, Commands>();
        commandsMap.put("push", new Push());
        commandsMap.put("print", new Print());
        commandsMap.put("pop", new Pop());
        commandsMap.put("add", new Addition());
        commandsMap.put("define", new Define());
        commandsMap.put("div", new Division());
        commandsMap.put("sqrt", new Sqrt());
        commandsMap.put("multi", new Multiplication());
        commandsMap.put("sub", new Subtraction());

        Map<String, Double> variableMap = new HashMap<String, Double>();

        String s;

        assert scanner != null;
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            String[] str = s.split(" ");

            if (commandsMap.containsKey(str[0])) {
                try {
                    commandsMap.get(str[0]).execute(stack, variableMap, str);
                } catch (NumberFormatException ex) {
                    log.error(ex);
                }
            } else {
                log.error("Unregistered command in commandsMap");
            }
        }
    }
}