package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */
    public static void main(String[] args) {
        // TODO implement
        int i=0;
        int res=1;

        while (i<20){
            res=res*2;
            i+=1;
            System.out.println(res);
        }

    }
}
