package com.jcourse.gaas.stackcalc.command;

import com.jcourse.gaas.stackcalc.ArgType;
import com.jcourse.gaas.stackcalc.Inject;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

public class CommandFactory {
    private static Logger LOG = Logger.getRootLogger();
    private static final Stack<Double> STACK = new Stack<>();
    public static final Map<String, Double> VARIABLES = new HashMap<>();
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(CommandFactory.class.getClassLoader().getResourceAsStream("commands.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    public static Command createCommand(String command, boolean proxy)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String[] words = command.split(" ");
        String className = properties.getProperty(words[0]);
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        Command command1 = (Command) clazz.newInstance();
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
            return createProxy(command1);
        } else {
            return command1;
        }
    }

    private static class LoggerInvocationHandler implements InvocationHandler {
        private Command command;

        LoggerInvocationHandler(Command command) {
            this.command = command;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(command, args);
            return result;
        }
    }

    private static Command createProxy(Command command) {
        Command proxy = (Command) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]
                {Command.class}, new LoggerInvocationHandler(command));
        return proxy;
    }
}