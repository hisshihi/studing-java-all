package org.example;

import org.example.computer.Computer;
import org.example.computer.Ram;
import org.example.computer.Ssd;

public class Main {
    public static void main(String[] args) {

        Ram ram = new Ram(16);
        Ssd ssd = new Ssd(1024);
        Computer computer = new Computer(ram, ssd);
        computer.printState();

    }
}