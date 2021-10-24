package com.ifmo.lesson6;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;
    public static int size = 0;

    private Object[] values;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        // TODO implement.
        /**
         * Добавляет значение в конец списка.
         *
         * @param val Значение, которое будет добавлено.
         */
        if (size==values.length){
            Object[] largerArray = new Object[values.length*2];
            System.arraycopy(values, 0, largerArray, 0, values.length);
            System.out.println("Array is extended");
            System.out.println(Arrays.toString(largerArray));
            values = largerArray;
        }
        values[size]=val;
        System.out.println(Arrays.toString(values));
        size++;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        // TODO implement.

        return values[i];
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        // TODO implement.
        /**
         * Удаляет значение по индексу и возвращает
         * удаленный элемент.
         *
         * @param i Индекс, по которому будет удален элемент.
         * @return Удаленное значение или {@code null}, если не найдено.
         */
        if (i>=values.length){
            return null;
        }

        if (values[i]==null){
            return null;
        }

        Object val = values[i];
        if (i==values.length-1){
            values[i]=null;
            return val;
        }
        Object[] tempArray = new Object[values.length];
        System.arraycopy(values, 0, tempArray, 0, i);
        System.out.println("Array is decreased");
        System.out.println(Arrays.toString(tempArray));
        System.arraycopy(values, i+1, tempArray, i, values.length-i-1);
        System.out.println(Arrays.toString(tempArray));
        values = tempArray;


        return val;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            // TODO implement.
            public static int index = 0;
//            Object current = values[index];


            public boolean hasNext() {
                return values[index] != null;
            }


            public String next() {
                if (hasNext()) {
                    String data = (String) values[index];
                    index++;
                    return data;
                }
                return null;
            }
        };
    }
}
