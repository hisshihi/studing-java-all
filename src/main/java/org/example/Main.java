package org.example;

import org.example.tasks.Task1;
import org.example.time.TimeInterval;

public class Main {
    public static void main(String[] args) {

//        this task 1
        Task1 task1 = new Task1();
        System.out.println(task1.replace());

//        this task 2
        System.out.println(task1.beginsAndEnds("Eye in eye", "eye"));

//        this task 3
        System.out.println(task1.fio("Kozykhin", "Denis", "Dmintrievich"));

//        this task 4
        System.out.println(task1.сountingСommasAndExclamationMarksInALine("sadf , aasfd.!afdsf34,,"));

//        this task 5

        System.out.println(task1.split("Hello I`am Denis", 3));

    }
}