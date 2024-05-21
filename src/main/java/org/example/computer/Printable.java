package org.example.computer;

import java.util.Random;

public interface Printable {

    String SOME_VALUE = "Example";
    Random RANDOM = new Random();

//    Дефолтный метод который запускается при инициализации интерфейса
    default void printWithRandom() {
        System.out.println(RANDOM.nextInt());
        printState();
    }

    void printState();

    private int generateRandom() {
        return RANDOM.nextInt();
    }


}
