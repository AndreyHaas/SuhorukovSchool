package com.jcourse.gaas.firstlession.tasks.second;

import java.util.Random;
import java.util.Scanner;

class Calculation {
    private static final byte ATTEMPT_MAX_COUNT = 8;

    private static int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(100 + 1);
    }

    static void calculate() {
        Scanner scanner = new Scanner(System.in);
        int rndVal = generateRandomValue();
        byte attempt = 0;

        while (scanner.hasNext()) {
            byte userValue = scanner.nextByte();
            attempt++;

            if (attempt == ATTEMPT_MAX_COUNT) {
                System.out.println("Превышено количество попыток");
                break;
            }

            if (userValue < rndVal) {
                System.out.println("Псевдо-случайное число БОЛЬШЕ указанного вами");
                attempt++;
            } else if (userValue > rndVal) {
                System.out.println("Псевдо-случайное число МЕНЬШЕ указанного вами");
                attempt++;
            } else {
                System.out.println("Вы угадали c " + attempt + "-го раза");
                break;
            }
        }
    }
}