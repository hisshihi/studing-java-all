package org.example.computer;

public class Mobile extends Computer{
    public Mobile(Ram ram, Ssd ssd) {
        super(ram, ssd);
    }

    @Override
    public void open() {
        System.out.println("Mobile is active");
    }

    @Override
    public void printState() {
        System.out.println("Mobile: ram " + getRam().getValue() + " ssd " + getSsd().getValue());
    }
}
