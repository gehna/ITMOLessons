package com.ifmo.lesson3;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();

        // TODO implement
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            System.out.println(fibonacciNumbers[i]);

        }
    }

    public static int[] fibonacciNumbers() {
        // TODO implement
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
//        System.out.println(arr[1]);
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
//            System.out.println(arr[i]);
        }

        return arr;
    }

}
