package org.example;

import org.example.mapExample.LinkedHashMapExample;
import org.example.mapExample.MapExample;
import org.example.person.Person;
import org.example.sortExample.SortExample;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SortExample sortExample = new SortExample();
        List<Person> result = sortExample.getSortExamplePersonByComparator();
        System.out.println(result);

    }
}