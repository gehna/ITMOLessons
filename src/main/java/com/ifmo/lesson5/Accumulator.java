package com.ifmo.lesson5;

public class Accumulator {
    private int value;
    private Operation op;

    int[] values;
    public Operation[] operations;

    public int[] getValue(){
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        return values;
    }



    public void accumulate(int a){
        for (int i = 0; i < values.length; i++) {
            values[i]=operations[i].calculate(values[i], a);
        }
//        value = op.calculate(value, a);
    }

    public Accumulator(int[] values, Operation[] op){
        this.values = values;
        this.operations = op;
    }

    public Accumulator(Operation op){
        this(0, op);
    }

    public Accumulator(int startValue, Operation op){
        this.value = startValue;
        this.op = op;
    }

    public static void main(String[] args) {
       int[] values = {0, 0};
       Operation[] operations = {new Plus(), new Minus()};
//
//        после вызова метода calculate(1) в values должны оказаться такие значения:
//|1|-1|
//                При следующем вызове, например, calculate(5):
//|6|-6|
//
//                Конструктор будет принимать два массива: int[] и Operation[].

        Accumulator acc = new Accumulator(values, operations);
        System.out.println(acc.getValue());
        acc.accumulate(1);
        System.out.println(acc.getValue());
        acc.accumulate(5);
        System.out.println(acc.getValue());

//        Accumulator acc = new Accumulator(0, new Plus());
//        acc.accumulate(2);
//        acc.accumulate(5);
//        System.out.println(acc.getValue());
//
//        Accumulator acc1 = new Accumulator(0, new Minus());
//        acc1.accumulate(2);
//        acc1.accumulate(5);
//        System.out.println(acc1.getValue());
//
//        Accumulator acc2 = new Accumulator(1, new Multiply());
//        acc2.accumulate(2);
//        acc2.accumulate(5);
//        System.out.println(acc2.getValue());
//
//        System.out.println("Divide");
//        Accumulator acc3 = new Accumulator(6, new Divide());
//        acc3.accumulate(2);
//        System.out.println(acc3.getValue());
//
//        System.out.println("Mod");
//        Accumulator acc4 = new Accumulator(10, new Mod());
//        acc4.accumulate(6);
//        System.out.println(acc4.getValue());
//
//        System.out.println("Power");
//        Accumulator acc5 = new Accumulator(2, new Power());
//        acc5.accumulate(3);
//        System.out.println(acc5.getValue());
//
//        Accumulator acc6 = new Accumulator(4, new SquareRoot());
//        acc6.accumulate(10000);
//        System.out.println(acc6.getValue());
    }
}
