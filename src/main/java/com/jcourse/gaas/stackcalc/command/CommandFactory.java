package com.jcourse.gaas.stackcalc.command;

import com.jcourse.gaas.stackcalc.ArgType;
import com.jcourse.gaas.stackcalc.Inject;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CommandFactory {
    private static Logger LOG = Logger.getRootLogger();
    private static final Stack<Double> STACK = new Stack<>();
    private static final Map<String, Double> VARIABLES = new HashMap<>();
    private static Properties properties;

    static {
        properties = new Properties();//Map<String, String>
        try {
            properties.load(CommandFactory.class
                    .getClassLoader()
                    .getResourceAsStream("commands.properties"));
        } catch (IOException e) {
            LOG.error("Property file not found");
        }
    }

    public static Command createCommand(String cmd, boolean proxy) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {

        String[] words = cmd.split(" ");
        String className = properties.getProperty(words[0].toUpperCase());
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();

        Command command = (Command) clazz.newInstance();

        for (Field field : fields) {
            Inject inject = field.getAnnotation(Inject.class);

            if (inject != null) {
                ArgType argType = inject.arg();
                field.setAccessible(true);

                switch (argType) {
                    case STACK:
                        field.set(command, STACK);
                        break;
                    case VARIABLE:
                        field.set(command, VARIABLES);
                        break;
                    case ARGS:
                        field.set(command, words);
                        break;
                    default:
                        throw new IllegalStateException("Unknown argType");
                }
            }
        }

        if (proxy) {
            return createProxy(command);
        } else {
            return command;
        }
    }

    private static class LoggerInvocationHander implements InvocationHandler {
        private Command command;

        public LoggerInvocationHander(Command command) {
            this.command = command;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;
            result = method.invoke(command, args);
            return result;
        }
    }

    private static Command createProxy(Command command) {
        Command proxy;
        proxy = (Command) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Command.class},
                new LoggerInvocationHander(command));
        return proxy;
    }
}