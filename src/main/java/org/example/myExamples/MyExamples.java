package org.example.myExamples;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyExamples {

    /*
    * Задание 1: Фильтрация и преобразование списка
    * Напишите программу, которая принимает список строк, фильтрует строки, длина которых больше 3 символов,
    * преобразует оставшиеся строки в верхний регистр и выводит их в отсортированном виде.
    * */

    public List<String> task1(List<String> strings) {
        List<String> result = strings.stream()
                .filter(string -> string.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return result;
    }

    /*
    * Задание 2: Работа с числами
    * Напишите программу, которая генерирует список целых чисел от 1 до 100,
    * затем фильтрует чётные числа, вычисляет их квадраты и находит сумму всех квадратов.
    * */
    public void task2() {
        int numbers = IntStream.rangeClosed(1, 100)
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .sum();
        System.out.println(numbers);
    }


    class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name=" + name +
                    ", age=" + age +
                    '}';
        }
    }

    /*
     * Задание 3: Группировка объектов
     * Напишите программу, которая принимает список пользователей и группирует их по возрасту.
     * Пользователь представлен классом с полями name и age.
     * */
    public void task3() {
        List<User> users = List.of(
                new User("Denis", 21),
                new User("Arina", 21),
                new User("Ivan", 20),
                new User("Sergey", 48),
                new User("Danila", 33)
        );

        Map<Integer, List<User>> groupByAge = users.stream()
                .collect(Collectors.groupingBy(user -> user.age));

        groupByAge.forEach((age, userList) -> {
            System.out.println("Age " + age + " : " + userList);
        });
    }

    /*
    * Задание 4: Поиск в коллекции
    * Напишите программу, которая принимает список чисел и находит первое число,
    * которое больше 50, если такое число существует.
    * */
    public void task4(List<Integer> integers) {
        Optional<Integer> firstGreatThan50 = integers.stream()
                .filter(integer -> integer > 50)
                .findFirst();

        firstGreatThan50.ifPresentOrElse(
                number -> System.out.println("Первое число больше 50: " + number),
                () -> System.out.println("Числа больше 50 не найдено")
        );
    }
}
