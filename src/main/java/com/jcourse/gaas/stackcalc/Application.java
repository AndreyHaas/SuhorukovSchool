package com.jcourse.gaas.stackcalc;

import com.jcourse.gaas.stackcalc.command.Command;
import com.jcourse.gaas.stackcalc.command.CommandFactory;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Application {
    private static Logger LOG = Logger.getRootLogger();

    public static void main(String[] args) {
        Scanner scanner = null;
        String s;
        Stack<Double> stack = new Stack<>();

        if (args.length > 0) {
//            try {
                scanner = new Scanner(Application.class.getClassLoader().getResourceAsStream(args[0]));
//            } finally {
//                if (scanner != null) {
//                    scanner.close();
//                }
//            }
        } else {
            scanner = new Scanner(System.in);
        }

        Map<String, Double> varMap = new HashMap<>();

        if (scanner != null) {
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                String[] str = s.split(" ");

                Command commandByName = null;
                try {
                    commandByName = CommandFactory.createCommand(str[0],true);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                if (commandByName != null) {
                    try {
                        commandByName.execute(stack, varMap, str);
                    } catch (NumberFormatException e) {
                        System.out.println("Введена неизвестная команда");
                        LOG.error("Введена неизвестная команда");
                    }
                } else {
                    System.out.println("Команда не найдена");
                    LOG.error("Команда не найдена");
                }
            }
        }
    }
}