package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList implements List, Stack, Queue {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        Item item = new Item(val);
        if (head==null){
            head=item;
        } else {
            Item current = head;
            while (true){
                if (current.next == null){
                    current.next = item;
                    break;
                }
                current = current.next;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object take() {
        // TODO implement.
        /**
         * Удаляет элемент из головы очереди.
         *
         * @return Данные, которые будут удалены из очереди или {@code null}, если очередь пустая.
         */
        if (head == null){
            return null;
        }
        Item item = head;
        item = head;
        head = head.next;
        return item.value;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        if (head==null){
            return null;
        }
        int counter = 0;
        Item current = head;
        while (true){

            if (counter==i){
                return current.value;
            }
            if (counter<i && current.next==null){
                return null;
            }
            current = current.next;
            counter++;

        }
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        // TODO implement
        if (head==null){
            return null;
        }

        int counter = 0;
        Item current = head;
        Item prev = head;

        if (i==0){
            head=current.next;
            return prev.value;
        }

        while (true){
            if (counter==i){
                prev.next = current.next;
                return current.value;
            }
            if (counter<i && current.next==null){
                return null;
            }
            prev=current;
            current=current.next;
            counter++;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            // TODO implement.
            Item current = head;


            public boolean hasNext() {
                return current != null;
            }


            public String next() {
                if (hasNext()) {
                    String data = (String) current.value;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
    }

    /** {@inheritDoc} */
    @Override
    public void push(Object value) {
        // TODO implement.
        Item item = new Item(value);
        item.next = head;
        head = item;

    }



    /** {@inheritDoc} */
    @Override
    public Object pop() {
        // TODO implement.
        if (head == null){
            return null;
        }
        Item item = head;
        head = head.next;
        return item.value;
    }


}
