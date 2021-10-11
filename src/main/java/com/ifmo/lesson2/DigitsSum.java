package com.ifmo.lesson2;

import java.util.Scanner;

public class DigitsSum {
    /*
    Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
    его цифр (заранее не известно сколько цифр будет в числе).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int digitSum = digitSum(n);

        System.out.println(digitSum);
    }

    public static int digitSum(int n) {
        // TODO implement
        int num = 0;
        int countofsymbols = String.valueOf(n).length();
        for (int i=1; i<countofsymbols; i++){
//            System.out.println("i="+i+"sss="+n/((int) Math.pow(10,i))%(10));
            num = num + n/((int) Math.pow(10,i))%(10);
        }
        num = num+n%10;

        return num;
    }
}
