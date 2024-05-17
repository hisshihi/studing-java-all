package org.example;

import org.example.time.TimeInterval;

public class Main {
    public static void main(String[] args) {

        TimeInterval timeInterval = new TimeInterval(234, 545, 22);

        int total = timeInterval.totalSeconds(33, 35, 45);
        timeInterval.print();
        System.out.println("Всего секунд - " + total);

        String string1 = "Hello World";
        System.out.println(string1.toLowerCase().endsWith("world"));

    }
}