package org.example.mapExample;

import org.example.person.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExample {

    Person denis = new Person(1, "Denis", "Hiss");
    Person arina = new Person(2, "Arina", "Kovaleva");
    Person outrun = new Person(1, "outrun", "outrunovich");

    public void getMapExample() {
        Map<Integer, Person> personMap = new HashMap<>();

        personMap.put(denis.getId(), denis);
        personMap.put(arina.getId(), arina);
//        Кладём значение если такого ключа нет, если он есть, то меняем ключ
        personMap.putIfAbsent(outrun.getId(), outrun);

        // Множество всех значений
        System.out.println(personMap.keySet());
        // Множество всех значений
        System.out.println(personMap.values());
        // Множество всех пар ключ - значение
        System.out.println(personMap.entrySet());

        System.out.println(personMap.containsKey(1));
        System.out.println(personMap.size());
//        Пустой или нет
        System.out.println(personMap.isEmpty());
//        Возвращаем дефолтное значение если под id ничего нет
        System.out.println(personMap.getOrDefault(5, outrun));

    }
}
