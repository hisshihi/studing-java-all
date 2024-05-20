package org.example;

import org.example.computer.*;

public class Main {
    public static void main(String[] args) {

//        Тип ссылки          Тип объекта
        Computer laptop = new Laptop(new Ram(15), new Ssd(512), 2);
        Computer mobile = new Mobile(new Ram(8), new Ssd(128));

//        loadComputers(laptop, mobile);
//        printStaticInfo(new Computer[] {laptop, mobile});
        print(laptop, mobile);
    }

    public static void loadComputers(Computer... computers) {
        for (Computer computer : computers) {
            computer.open();
        }
    }
    
    public static void printStaticInfo(Computer... computers) {
        for (Computer computer : computers) {
            computer.printState();
            if (computer instanceof Laptop laptop) {
                laptop.open();
            }
        }
    }

    public static void print(Printable... objects) {
        for (Printable object : objects) {
            object.printState();
        }
    }
}