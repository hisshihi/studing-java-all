package org.example.treeMap;

import org.example.person.Person;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public void getTreeMapExample() {
        Person denis = new Person(1, "Denis", "Hiss");
        Person arina = new Person(29, "Arina", "Kovaleva");
        Person outrun = new Person(3, "outrun", "outrunovich");
        Person ivan = new Person(32, "outrun1", "outrunovich1");
        Person sergey = new Person(33, "outrun2", "outrunovich2");
        Person nikita = new Person(81, "outrun3", "outrunovich3");
        Person ilia = new Person(7, "outrun4", "outrunovich4");

        Map<Integer, Person> personMap = new TreeMap<>();

        personMap.put(denis.getId(), denis);
        personMap.put(arina.getId(), arina);
        personMap.put(outrun.getId(), outrun);
        personMap.put(ivan.getId(), ivan);
        personMap.put(sergey.getId(), sergey);
        personMap.put(nikita.getId(), nikita);
        personMap.put(ilia.getId(), ilia);

        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
