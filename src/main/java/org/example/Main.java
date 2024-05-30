package org.example;

import org.example.fileExample.FileTasks;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("src", "main", "resources", "text.txt");
        Path pathFileTask4 = Path.of("src", "main", "java", "org", "example", "functionalProgrammingPracting", "FunctionalProgrammingTasks.java");

        FileTasks fileTasks = new FileTasks();

//        task 1
//        fileTasks.task1(path);

//        task 2
//        fileTasks.task2(path);

//        task 3
//        fileTasks.task3(path);

//        task 4
//        fileTasks.task4(pathFileTask4);

//        task 5
        fileTasks.task5(pathFileTask4);
    }
}