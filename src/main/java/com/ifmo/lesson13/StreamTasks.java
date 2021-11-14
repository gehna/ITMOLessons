package com.ifmo.lesson13;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {
    private static final List<String> COUNTRIES = Arrays.asList("Germany", "Russia", "Mexico", "Ghana", "Japan");
    private static final List<String> NAMES = Arrays.asList("Bob", "Alice", "Nick", "Ted", "Quentin", "David", "Zack", "Stacy", "Helen", "Julia");

    public static Person randomPerson() {
        return new Person(NAMES.get((int) (Math.random() * 9)), (int) (Math.random() * 99), COUNTRIES.get((int) (Math.random() * 4)));
    }

    static class Person {
        final String name;
        final int age;
        final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople(100).collect(Collectors.toList());

        List<String> countries = countriesSortedByTheirPopulationDescending(people.stream());
        String countryThatHasMostKids = countryThatHasMostKids(people.stream());
        Map<String, Long> populationByCountry = populationByCountry(people.stream());

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);
    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        // TODO implement.
        List<Person> collect = people.collect(Collectors.toList());
        Map<String, Integer> stringIntegerMap = generateCountryCount(collect);
        return List.copyOf(collect.stream().sorted(((o1, o2) -> comparingByCountrySize(stringIntegerMap, o1, o2))).map(o -> o.country).collect(Collectors.toSet()));
    }

    private static int comparingByCountrySize(Map<String, Integer> stringIntegerMap, Person o1, Person o2) {
        Integer o1Count = stringIntegerMap.get(o1.country);
        Integer o2Count = stringIntegerMap.get(o2.country);
        return o2Count.compareTo(o1Count);
    }

    private static Map<String, Integer> generateCountryCount(List<Person> collect) {
        HashMap<String, List<Person>> stringListHashMap = new HashMap<>();
        for (Person p :
                collect) {
            List<Person> pe = stringListHashMap.get(p.country);
            if (Objects.nonNull(pe)) {
                pe.add(p);
                stringListHashMap.put(p.country, pe);
            } else {
                stringListHashMap.put(p.country, new ArrayList<>());
            }
        }
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (Map.Entry<String, List<Person>> entry :
                stringListHashMap.entrySet()) {
            stringIntegerHashMap.put(entry.getKey(), entry.getValue().size());
        }
        return stringIntegerHashMap;
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        // TODO implement.
        Optional<String> first = people.filter(person -> person.age < 18)
                .collect(Collectors.groupingBy(person -> person.country, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return first.orElse(null);
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        // TODO implement.
        return people.collect(Collectors.groupingBy(person -> person.country, Collectors.counting()));
    }

    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        // TODO implement.
        return Stream.generate(StreamTasks                                                              ::randomPerson).limit(number);
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        // TODO implement.
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        // TODO implement.

        return (int) words.stream()
                .map(String::length)
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getAverage();
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        // TODO implement.
        int max = words.stream().map(String::length)
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getMax();

        return words.stream().filter(w -> w.length() == max).collect(Collectors.toSet());
    }


}