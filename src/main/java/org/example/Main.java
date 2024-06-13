package org.example;

import org.example.myExamples.MyExamples;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> strings = List.of("Денис", "Арина", "Дуся", "Роза", "Буся", "Бу");

        MyExamples examples = new MyExamples();
        List<String> task1 = examples.task1(strings);
        System.out.println(task1);

        examples.task2();
        examples.task3();

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 40, 70);
        examples.task4(numbers);

    }
}