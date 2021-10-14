package com.ifmo.lesson3;

import java.util.concurrent.ThreadLocalRandom;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]);
        }
        System.out.println();
        int[] replacedWithZeros = replaceWithZeros(randomNumbers);
        for (int i = 0; i < replacedWithZeros.length; i++) {
            System.out.print(replacedWithZeros[i]);
        }
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] myArray = new int[8];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }

        return myArray;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        // TODO implement
        for (int i = 0; i < randomNumbers.length; i++) {
            if (i%2==1){
                randomNumbers[i]=0;
            }
        }

        return randomNumbers;
    }
}
