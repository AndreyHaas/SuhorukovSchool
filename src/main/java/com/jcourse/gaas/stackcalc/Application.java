package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.commands.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<Double>();
        Scanner scanner = null;

        if (args.length > 0) {
            try {
                scanner = new Scanner(new FileInputStream(args[0]));
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
        } else {
            scanner = new Scanner(System.in);
        }

        String s;

        Map<String, Commands> commandsMap = new HashMap<String, Commands>();
        commandsMap.put("push", new Push());
        commandsMap.put("print", new Print());
        commandsMap.put("pop", new Pop());
        commandsMap.put("add", new Addition());
        commandsMap.put("define", new Define());
        commandsMap.put("div", new Division());
        commandsMap.put("sqrt", new Sqrt());
        commandsMap.put("multi", new Multiplication());

        Map<String, Double> variableMap = new HashMap<String, Double>();

        while (scanner.hasNext()) {
            s = scanner.nextLine();
            String[] str = s.split(" ");
            if (commandsMap.containsKey(str[0])) {
                try {
                    commandsMap.get(str[0]).execute(stack, variableMap, str);
                } catch (NumberFormatException e) {
                    System.out.println("Unknown command");
                }
            } else {
                System.out.println("Unregistered command in commandsMap");
            }
        }
    }
}