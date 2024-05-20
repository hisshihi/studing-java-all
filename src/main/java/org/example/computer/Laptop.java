package org.example.computer;

public class Laptop extends Computer{

//    Super - вызываем конструктор суперкласса,
//    с помощью него можем получить значения конструктора родительского класса

    private int weight;

    public Laptop(Ram ram, Ssd ssd, int weight) {
        super(ram, ssd);
        this.weight = weight;
    }

    public void printState() {
        Ssd ssd = new Ssd(512);
        setSsd(ssd);
        System.out.println("Laptop: ram " + getRam().getValue() + " ssd " + getSsd().getValue());
    }

    public void open() {
        System.out.println("Laptop is open");
    }


}
