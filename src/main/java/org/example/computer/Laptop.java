package org.example.computer;

public class Laptop extends Computer{

//    Super - вызываем конструктор суперкласса,
//    с помощью него можем получить значения конструктора родительского класса

    private int weight;

    public Laptop(Ram ram, Ssd ssd, int weight) {
        super();
        this.weight = weight;
    }

    public Laptop() {
        System.out.println("Constructor laptop");
    }

    /*
    * Блоки инициализации
    * Используются редко
    * */

    {
        System.out.println("init block laptop");
    }

    static {
        System.out.println("static block laptop");
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
