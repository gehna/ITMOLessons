package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */
    public static void main(String[] args) {
        // TODO implement

        int i=0;
        int res=-1;

        while (i<55){
            res=res+2;
            i+=1;
            System.out.println(res);
        }
    }
}
