package org.example;

import org.example.generics.List;
import org.example.taskOop.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new List<>(10);
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");

        Object element = list.get(1);
        System.out.println(element);

    }
}