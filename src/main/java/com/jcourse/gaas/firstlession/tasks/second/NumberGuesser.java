package com.jcourse.gaas.firstlession.tasks.second;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class NumberGuesser {
    private static final int ATTEMPT_MAX_COUNT = 8;
    private static final String CONFIRM_CONTINUE = "YES";
    private static final String REFUSING_CONTINUE = "NO";
    private int attempt = 0;

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private void reRun() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Продолжим?");
        System.out.println("Yes/No");
        String confirmation = scanner.nextLine().toUpperCase();

        if (confirmation.equals(CONFIRM_CONTINUE)) {
            System.out.println("Итак, продолжим игру :)");
            attempt = 0;
            game();
        } else if (confirmation.equals(REFUSING_CONTINUE)) {
            System.out.println("Вы отказались от игры со мной :(");
            scanner.close();
        } else {
            reRun();
        }
    }


    public void game() {
        Scanner scanner = new Scanner(System.in);
        int randomValue = getRandomValue();

        System.out.println("Загадано число от 1 до 100 включительно, отгадайте его с 8-ми попыток");

        while (scanner.hasNext()) {
            try {
                int userValue = scanner.nextInt();
                attempt++;
                if (attempt >= ATTEMPT_MAX_COUNT) {
                    System.out.println("Превышено количество попыток");
                    reRun();
                    return;
                }

                if (userValue < randomValue) {
                    System.out.println("Загаданное число БОЛЬШЕ указанного вами");
                } else if (userValue > randomValue) {
                    System.out.println("Загаданное число МЕНЬШЕ указанного вами");
                } else {
                    System.out.println("Вы угадали c " + attempt + "-го раза");
                    reRun();
                }
            } catch (InputMismatchException ex) {
                attempt++;
                System.out.println("Введено значение не удовлетворяющее требованию игры. Попытка засчитана");
                scanner.next();
            }
        }
    }
}