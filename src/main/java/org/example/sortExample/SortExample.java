package org.example.sortExample;

import org.example.person.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public List<String> getSortExample() {
        List<String> strings = Arrays.asList("123", "456", "14", "589");

        Collections.sort(strings);

        return strings;
    }

    public List<Person> getSortExamplePerson() {
        List<Person> persons = Arrays.asList(
                new Person(1, "Hiss", "Dev"),
                new Person(29, "Outrun", "Dev"),
                new Person(11, "Denis", "Dev")
        );
        Collections.sort(persons);
        return persons;
    }

    public List<Person> getSortExamplePersonByComparator() {
        List<Person> personList = Arrays.asList(
                new Person(1, "Hiss", "Dev"),
                new Person(29, "Outrun", "Dev"),
                new Person(11, "Denis", "Dev")
        );

//        personList.sort(new FirtsNameComparator());
//        Множественная сортировка
        personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        return personList;
    }

    public static class FirtsNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

}
