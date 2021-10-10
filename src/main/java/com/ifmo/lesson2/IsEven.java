package com.ifmo.lesson2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class IsEven {
    /*
    Создать программу, проверяющую и сообщающую на экран, является ли целое число
    записанное в переменную n, чётным либо нечётным.
     */
    public static void main(String[] args) {
        int n = 24;

        System.out.println(isEven(n));
    }

    @Contract(pure = true)
    public static @NotNull String isEven(int n) {
        // TODO implement
        // Допустимые строки: "Четное" или "Нечетное"
        if (n%2==0){
            return "Четное";
        }
        return "Нечетное";
    }
}
