package org.example.functionalProgrammingPracting;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FunctionalProgrammingTasks {

    /*
     * Дан список целых чисел. Найти среднее всех
     * нечётных чисел, делящихся на 5.
     * */
    public void task1() {
        List<Integer> list = List.of(1, 3, 4, 6, 8, 5, 15, 20, 25, 10);
        OptionalDouble optionalDouble = list.stream()
                .filter(value -> value % 2 != 0)
                .filter(value -> value % 5 == 0)
//                Получаем поток примитивных типов
                .mapToInt(Integer::intValue)
//                Получаем среднее арифметическое
                .average();
        optionalDouble.ifPresent(System.out::println);
    }

    /*
     * Дан список строк. Найти кол-во уникальных
     * строк длинной более 8 символов
     * */
    public void task2() {
        List<String> list = List.of(
                "string-1",
                "string-2",
                "string-3",
                "string-4",
                "string-10",
                "string-10",
                "string-12",
                "string-12",
                "string-16",
                "string-18"
        );
        int result = list.stream()
                .filter(value -> value.length() > 8)
                .collect(Collectors.toSet())
                .size();

        long result2 = list.stream()
                .filter(value -> value.length() > 8)
//                Убираем все дубликаты
                .distinct()
                // Находим количество
                .count();
        System.out.println(result2);
    }

    /*
     * Дана Map<String, Integer>. Найти сумму всех значений,
     * длина ключей которых меньше 7 символов.
     * */
    public void task3() {
        Map<String, Integer> map = Map.of(
                "string1", 1,
                "strin2", 2,
                "string3", 3,
                "string4", 4,
                "strin5", 5
        );
        Integer result = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(result);

    }

    /*
     * Дан список целых чисел,
     * вывести строку, представляющую собой конкатенацию
     * строковых представлений этих чисел.
     * Пример: список {5, 2, 4, 2, 1}
     * Результирующая строка: "52321"
     * */
    public void task4() {
        List<Integer> list = List.of(5, 2, 4, 2, 1);
        String result = list.stream()
//                Преобразовываем числа в строки
                .map(String::valueOf)
//                Также можно указать, как будут разделены строки, что будет стоять впереди "prefix" и что сзади "suffix"
//                        .collect(Collectors.joining(",", "Prefix: ", " end"));
                // конкатенируюем строки между собой
                .collect(Collectors.joining());
        System.out.println(result);
    }

    /*
     * Дан класс Person с полями furstName, lastName and age
     * Вывести полное имя самого старшего человека,
     * у которого длина имени не превышает 15 символов
     * */
    public void task5() {
        List<Person> persons = List.of(
                new Person("Denis", "Hiss", 21),
                new Person("Arina", "Hair", 21),
                new Person("Sergey", "Pacifist", 20),
                new Person("Slava", "Kpss", 27),
                new Person("Ruslan", "CMH", 28),
                new Person("Vova", "Bratishkin", 26),
                new Person("Danila", "Kashin", 28),
                new Person("Nikolai", "Lida", 29)
        );

        persons.stream()
                .filter(person -> person.getFullName().length() < 15)
//                Сравниваем два значения с помощью компаратора и находим максимальное
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);

//        преобразовываем в map, таким образом можем получить 2 и более значений по одному ключу
        Map<Integer, List<String>> collect = persons.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getFullName, toList())));

//        Map<Integer, Person> personMap = persons.stream()
//                        .collect(toMap(Person::getAge, Function.identity()));
        System.out.println(collect);

    }

}
