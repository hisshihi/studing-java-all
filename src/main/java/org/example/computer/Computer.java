package org.example.computer;

public class Computer {

    private Ram ram;
    private Ssd ssd;
    private static int count = 0;

    public void printState() {
        System.out.println("Computer: ram " + ram.getValue() + " ssd " + ssd.getValue());
    }

    public Computer(Ram ram, Ssd ssd) {
        this.ram = ram;
        this.ssd = ssd;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Ssd getSsd() {
        return ssd;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }
}
