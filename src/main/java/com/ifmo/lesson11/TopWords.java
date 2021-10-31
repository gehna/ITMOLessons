package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text = new File("wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println(top10Words(words));
        System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));
    }

    /**
     * Возвращает 10 наиболее часто встречающихся слов с их
     * счётчиками.
     *
     * @param words Список слов.
     * @return Map, где ключ - слово, а значение - сколько раз встретилось.
     */
    public static Map<String, Integer> top10Words(List<String> words) {
        // todo implement
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word: words){
            if (wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
            //1 проверяем есть ли слово в map
            //2 Если нет то добавляем его со значением 1
            //3 если есть то извлекаем значение, увеличиваем на 1 и
            // записываем в map

        }
//        List<Integer> employeeById = new ArrayList<>(wordCount.values());
//        Collections.sort(employeeById);
//        System.out.println(employeeById);

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(wordCount.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        int i = 0;
        for (Map.Entry<String, Integer> aa : list) {
            if (i >= list.size()-10){
                temp.put(aa.getKey(), aa.getValue());
            }
            i++;
        }
//        HashMap<String, Integer> tempLast10 = new LinkedHashMap<String, Integer>();
//        tempLast10.put(get(temp.size()-1)
////        for (int i = temp.size(); i < temp.size()-10; i--) {
////            tempLast10.put(temp.getKey(temp.get(i)));
////        }
//
//        tempLast10.get(temp.size()-1);
        return temp;
    }

    /**
     * Возвращает 10 наиболее часто встречающихся фраз и соответствующие счётчики.
     * Фраза - два подряд идущих слова.
     *
     * @param words Список слов.
     * @return Топ 10 фраз.
     */
    public static Map<String, Integer> top10Phrases(List<String> words) {
        // todo implement
        Map<String, Integer> wordPhrasesCount = new HashMap<>();
        for (int i = 0; i < words.size() - 1; i++) {

            String word1 = words.get(i);
            String word2 = words.get(i + 1);
//            System.out.println(word1+" "+word2);
                if (wordPhrasesCount.containsKey(word1 + " " + word2)) {
                    wordPhrasesCount.put(word1 + " " + word2, wordPhrasesCount.get(word1 + " " + word2) + 1);
                } else {
                    wordPhrasesCount.put(word1 + " " + word2, 1);
                }

                //1 проверяем есть ли слово в map
                //2 Если нет то добавляем его со значением 1
                //3 если есть то извлекаем значение, увеличиваем на 1 и
                // записываем в map

            }
//        List<Integer> employeeById = new ArrayList<>(wordCount.values());
//        Collections.sort(employeeById);
//        System.out.println(employeeById);

            // Create a list from elements of HashMap
            List<Map.Entry<String, Integer>> list =
                    new LinkedList<Map.Entry<String, Integer>>(wordPhrasesCount.entrySet());

            // Sort the list
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });

            // put data from sorted list to hashmap
            HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
            int k = 0;
            for (Map.Entry<String, Integer> aa : list) {
                if (k >= list.size() - 10) {
                    temp.put(aa.getKey(), aa.getValue());
                }
                k++;
            }
//        HashMap<String, Integer> tempLast10 = new LinkedHashMap<String, Integer>();
//        tempLast10.put(get(temp.size()-1)
////        for (int i = temp.size(); i < temp.size()-10; i--) {
////            tempLast10.put(temp.getKey(temp.get(i)));
////        }
//
//        tempLast10.get(temp.size()-1);
            return temp;
        }


    /**
     * Возвращает символы и частоту их встречаемости.
     *
     * @param words Список слов.
     * @return Map где ключ - символ, а значение - сколько раз он встретился в списке слов.
     */
    public static Map<Character, Integer> charactersFrequency(List<String> words) {
        // todo implement
        Map<Character, Integer> wordPhrasesCount = new HashMap<>();
        for (String word: words) {
            char[] chList = word.toCharArray();
            for (Character ch1 : chList) {

//            System.out.println(word1+" "+word2);
                if (wordPhrasesCount.containsKey(ch1)) {
                    wordPhrasesCount.put(ch1, wordPhrasesCount.get(ch1) + 1);
                } else {
                    wordPhrasesCount.put(ch1, 1);
                }

                //1 проверяем есть ли слово в map
                //2 Если нет то добавляем его со значением 1
                //3 если есть то извлекаем значение, увеличиваем на 1 и
                // записываем в map

            }
        }
//        List<Integer> employeeById = new ArrayList<>(wordCount.values());
//        Collections.sort(employeeById);
//        System.out.println(employeeById);

        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<Map.Entry<Character, Integer>>(wordPhrasesCount.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        int k = 0;
        for (Map.Entry<Character, Integer> aa : list) {
            if (k >= list.size() - 10) {
                temp.put(aa.getKey(), aa.getValue());
            }
            k++;
        }
//        HashMap<String, Integer> tempLast10 = new LinkedHashMap<String, Integer>();
//        tempLast10.put(get(temp.size()-1)
////        for (int i = temp.size(); i < temp.size()-10; i--) {
////            tempLast10.put(temp.getKey(temp.get(i)));
////        }
//
//        tempLast10.get(temp.size()-1);
        return temp;
    }
}
