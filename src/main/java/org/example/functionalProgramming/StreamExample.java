package org.example.functionalProgramming;

import java.util.List;

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

}
