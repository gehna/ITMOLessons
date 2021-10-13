package com.ifmo.lesson3;

import java.util.concurrent.ThreadLocalRandom;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]+" ");
        }
        // TODO implement
        System.out.println();
        System.out.println(isIncreasingSequence(randomNumbers));
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] myArray = new int[4];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ThreadLocalRandom.current().nextInt(10, 99);
        }

        return myArray;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        // TODO implement
        int prev = randomNumbers[0];
        boolean flag = true;
        for (int i = 1; i < randomNumbers.length; i++) {
            if (prev<randomNumbers[i]){
                prev = randomNumbers[i];
            } else {
                flag = false;
                break;
            }

        }

        return flag;
    }
}
