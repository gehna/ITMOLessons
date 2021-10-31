package com.ifmo.lesson11;

import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessageGenerator;
import com.ifmo.lesson11.inner.MessagePriority;

import java.util.*;

/*
    Реализуйте все методы.
 */
public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages));
        System.out.println("messages: \n" + messages);

        removeEach(generator.generate(100), MessagePriority.LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого приоритета.
        // Ответ необходимо вывести в консоль.
        List<Message> result = new ArrayList<>();
        for (MessagePriority word: MessagePriority.values()){
            result.add(new Message(word, 0));
        }
        for (int i = 0; i < messages.size(); i++) {
            int j = 0;
            while (true){
                if (result.get(j).getPriority() == messages.get(i).getPriority()){
                    result.get(j).setCode(result.get(j).getCode()+1);
                    break;
                }
                j++;
            }

        }
        System.out.println("countEachPriority result");
        System.out.println(result);
        // TODO implement
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.
        Map<Integer, Integer> result = new HashMap<>();
        for (Message message: messages) {
            if (result.containsKey(message.getCode())) {
                result.put(message.getCode(), result.get(message.getCode()) + 1);
            } else {
                result.put(message.getCode(), 1);
            }
        }

        System.out.println("countCountEachCode result");
        System.out.println(result);
        // TODO implement
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.
        int unique = 0;
        for (int i = 0; i < messages.size(); i++) {
            boolean find = false;
            for (int j = 0; j < messages.size(); j++) {
                if (i !=j && messages.get(i).equals(messages.get(j))){
                    find = true;
                }
            }
            if (!find){
                unique++;
            }

        }
        System.out.println("countUniqueMessages result");
        System.out.println(unique);
        // TODO implement
        // TODO implement
    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.
        List<Message> result = new ArrayList<>();

        result.add(new Message(messages.get(0).getPriority(), messages.get(0).getCode()));
        for (int i = 1; i < messages.size(); i++) {
            int j = 0;
            boolean find = false;
            while (true) {
                if (j>=result.size()) {
                    break;
                }

                if (result.get(j).equals(messages.get(i))) {
                    find = true;
                    break;
                }
                j++;
            }
            if (!find) {
                result.add(new Message(messages.get(i).getPriority(), messages.get(i).getCode()));
            }
        }
//            for (int j = 0; j < result.size(); j++) {
//                if (result.get(j).equals(messages.get(i))){
//                    continue;
//                }
//                result.add(new Message(messages.get(i).getPriority(), messages.get(i).getCode()));
//
//            }


        // TODO implement

        return result;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);

        // TODO implement

        System.out.printf("After remove each: %s, %s\n", priority, messages);
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);

        // TODO implement

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
