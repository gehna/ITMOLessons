package com.ifmo.lesson5;

public class SquareRoot implements Operation {
    @Override
    public int calculate(int a, int b) {
        return (int) Math.sqrt(a);
    }
}
