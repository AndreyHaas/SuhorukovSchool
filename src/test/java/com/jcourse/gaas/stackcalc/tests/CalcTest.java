package com.jcourse.gaas.stackcalc.tests;

import com.jcourse.gaas.stackcalc.command.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest {
    private Stack<Double> stack = new Stack<>();
    private Map<String, Double> map = new HashMap<>();

    @Test
    @DisplayName("Тест операции сложения")
    void addTest() {
        Command add = new Addition();
        double firstValue = 5.0;
        stack.push(firstValue);
        double secondValue = 4.0;
        stack.push(secondValue);
        add.execute(stack, map, new String[0]);
        assertEquals(9.0, stack.peek(), .000001);
    }

    @RepeatedTest(2)
    @DisplayName("Тест операции деления")
    void divTest() {
        Command div = new Division();
        double firstValue = 4.0;
        stack.push(firstValue);
        double secondValue = 4.0;
        stack.push(secondValue);
        div.execute(stack, map, new String[0]);
        assertEquals(1.0, stack.peek(), .000001);
    }

    /**
     * Unit-тест проверки операции умножения
     */
    @Test
    @DisplayName("Тест операции умножения")
    void multiplyTest() {
        Command multiplication = new Multiplication();
        double firstValue = 4.0;
        stack.push(firstValue);
        double secondValue = 4.0;
        stack.push(secondValue);
        multiplication.execute(stack, map, new String[0]);
        assertEquals(16.0, stack.peek(), .000001);
    }

    /**
     * Unit-тест проверки операции извлечения квадратного корня
     *
     * @ param - firstValue - значение из которого будет извлекаться квадратный корень
     */
    @Test
    @DisplayName("Тест операции извлечения квадратного корня")
    void sqrtTest() {
        Command sqrt = new Sqrt();
        double firstValue = 36.0;
        stack.push(firstValue);
        sqrt.execute(stack, map, new String[0]);
        assertEquals(6.0, stack.peek(), .000001);
    }

    /**
     * Unit-тест проверки операции вычитания
     */
    @Test
    @DisplayName("Тест операции вычитания")
    void subTest() {
        Command subtraction = new Subtraction();
        double firstValue = 4.0;
        stack.push(firstValue);
        double secondValue = 3.0;
        stack.push(secondValue);
        subtraction.execute(stack, map, new String[0]);
        assertEquals(-1.0, stack.peek(), .000001);
    }
}
