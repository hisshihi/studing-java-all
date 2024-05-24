package org.example.mapExample;

import org.example.person.Person;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public void getLinkedHashMapExample() {
        Person denis = new Person(1, "Denis", "Hiss");
        Person arina = new Person(29, "Arina", "Kovaleva");
        Person outrun = new Person(33, "outrun", "outrunovich");

        Map<Integer, Person> personMap = new LinkedHashMap<>();
        personMap.put(denis.getId(), denis);
        personMap.put(arina.getId(), arina);
        personMap.put(outrun.getId(), outrun);

        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
