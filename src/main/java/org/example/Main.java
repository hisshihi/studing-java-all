package org.example;

import org.example.person.Person;

public class Main {
    public static void main(String[] args) {

        Person denis = new Person(1, "Denis", "Hiss");
        Person arina = new Person(2, "Arina", "Kovaleva");
        Person denis2 = new Person(1, "Denis", "Hiss");

        System.out.println(denis.hashCode());
        System.out.println(arina.hashCode());
        System.out.println(denis2.hashCode());
        System.out.println(denis.equals(denis2));

    }
}