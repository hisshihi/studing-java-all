package org.example.functionalProgramming;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    List<String> strings = List.of("88", "11", "22", "33", "44", "55", "66");

    public void getStreamExample() {
        /*
         * Объяснение кода
         * 1. С помощью map итерируемся по всем значениям и применяем к каждому сложение
         * 2. Также с помощью map все значения преобразуем к integer с помощью ссылки на метод
         * 3. Фильтруем значения на чётность
         * 4. С помощью forEach который ничего не возвращает и является терминальной операцией
         * и после её вызова начинает выполняться стрим, то есть потоковая обработка элементов коллекции
         * */
        strings.stream()
                .map(string -> string + string)
                .map(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
//                Сортирует элементы
                .sorted()
                // Пропускает какой-либо элемент
//                .skip(1)
                // вывести только 2 элемента после первого
                .limit(2)
                .forEach(System.out::println);
    }

    public void getPrimitiveStream() {
        /*
        * IntStream
        * DoubleStream
        * LongStream
        * Все они работают для примитивных типов
        * */
        IntSummaryStatistics intSummaryStatistics =
                strings.stream()
                .map(string -> string + string)
                .map(Integer::valueOf)
                .filter(integer -> integer % 2 == 0)
//                Сортирует элементы
                .sorted()
                // Пропускает какой-либо элемент
//                .skip(1)
                // вывести только 2 элемента после первого
                .limit(2)
//                Преобразуем тип в нужный нам примитивный тип
                .mapToInt(Integer::intValue)
//                        .mapToObj(Integer::valueOf)
//                Получить статистику
                .summaryStatistics();

        List<String> list = Stream.of("88", "11", "22", "33", "44", "55", "66")
                .peek(System.out::println)
                .collect(Collectors.toList());

//        Итератор от 0 до 10 включительно
//        IntStream.rangeClosed(0, 10)
//                .forEach(System.out::println);
//        Вывод от 30 до 87 с шагом 3
        IntStream.iterate(0, value -> value + 3)
                .skip(10)
                .limit(20)
                .forEach(System.out::println);

    }

}
