package org.example;

import org.example.conllectinPractice.Practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15, 6);

        Map<String, String> map = Map.of(
                "Hiss", "Dev",
                "outrun", "hihi",
                "Arina", "ArlHair",
                "Sergey", "Pacifist",
                "Segay", "Pacifist"
        );

        Map<Integer, Integer> polynomail1 = Map.of(
                0, 5,
                1, 3,
                3, 2,
                5, 4,
                6, 7
        );
        Map<Integer, Integer> polynomail2 = Map.of(
                0, 5,
                3, 4,
                5, 5,
                6, 1
        );
        //    8x^6 + 9x^5 + 6x^3 + 3x^1 + 10

        Practice practice = new Practice();

//        task 1
        System.out.println(practice.Task1(list));

//        task 2
        System.out.println(practice.countUnique(list));

//        task 3
        System.out.println(practice.isUnique(map));

//        task 4
        System.out.println(practice.convertToString(practice.sum(polynomail1, polynomail2)));

    }
}