package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        // TODO implement
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

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        // TODO implement
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

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
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
}
