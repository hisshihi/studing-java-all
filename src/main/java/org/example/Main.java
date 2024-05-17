package org.example;

import org.example.computer.Computer;

public class Main {
    public static void main(String[] args) {

        new Computer(null, null);
        new Computer(null, null);
        new Computer(null, null);
        new Computer(null, null);
        
        System.out.println("Count - " + Computer.getCount());

    }
}