package com.ifmo.lesson5;

public class Mod implements Operation{
    @Override
    public int calculate(int a, int b) {
        return a%b;
    }
}
