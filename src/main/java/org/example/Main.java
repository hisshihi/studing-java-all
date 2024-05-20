package org.example;

import org.example.computer.Laptop;

public class Main {
    public static void main(String[] args) {

//        Laptop -> Computer -> Object
//        Laptop <- Computer <- Object
        Laptop laptop = new Laptop();
        laptop.open();


    }
}