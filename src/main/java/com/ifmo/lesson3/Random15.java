package com.ifmo.lesson3;

import java.util.concurrent.ThreadLocalRandom;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]);
        }
        System.out.println();

        int evens = evens(randomNumbers);
        System.out.println(evens);
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] myArray = new int[15];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ThreadLocalRandom.current().nextInt(0, 9);
        }

        return myArray;
    }

    private static int evens(int[] arr) {
        // TODO implement
        int evenCounter=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0 && arr[i]!=0){
                evenCounter++;
            }
        }

        return evenCounter;
    }
}
