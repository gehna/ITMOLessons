package com.ifmo.lesson5;

public class Power implements Operation {
    @Override
    public int calculate(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
