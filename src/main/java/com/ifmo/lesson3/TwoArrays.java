package com.ifmo.lesson3;

import java.util.concurrent.ThreadLocalRandom;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();

        // TODO implement
        for (int i = 0; i < randomNumbers1.length; i++) {
            System.out.print(randomNumbers1[i]);
        }
        System.out.println();
        for (int i = 0; i < randomNumbers2.length; i++) {
            System.out.print(randomNumbers2[i]);
        }
        System.out.println();

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        if(average1==average2){
            System.out.println("Averages are equal");
        }else if (average1>average2){
            System.out.println("First average is bigger");
        }else {
            System.out.println("Second average is bigger");
        }
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ThreadLocalRandom.current().nextInt(0, 5);
        }

        return myArray;
    }

    public static int average(int[] randomNumbers) {
        // TODO implement
        int sumNumber = 0;
        for (int i = 0; i <randomNumbers.length; i++) {
            sumNumber=sumNumber + randomNumbers[i];
        }

        return sumNumber/randomNumbers.length;
    }
}
