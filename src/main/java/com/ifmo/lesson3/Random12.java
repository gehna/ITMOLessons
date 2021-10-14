package com.ifmo.lesson3;

import java.util.concurrent.ThreadLocalRandom;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
//        for (int i = 0; i < randomNumbers.length; i++) {
//            System.out.print(randomNumbers[i]+" ");
//        }
//        System.out.println();
        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);

        // TODO implement
        System.out.println(maxLastIndex);
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] myArray = new int[12];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ThreadLocalRandom.current().nextInt(-15, 15);
        }

        return myArray;
    }

    public static int max(int[] randomNumbers) {
        // TODO implement
        int maxNumber = -15;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (maxNumber<randomNumbers[i]){
                maxNumber = randomNumbers[i];
            }
        }

        return maxNumber;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        // TODO implement
        int lasIndex=0;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i]==max){
                lasIndex = i;
            }
        }

        return lasIndex;
    }
}
