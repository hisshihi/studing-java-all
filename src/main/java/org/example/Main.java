package org.example;

import org.example.person.SerializationDemo;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("src", "main", "resources", "student.out");
        SerializationDemo serializationDemo = new SerializationDemo();
        serializationDemo.getSerializationDemo(path);

    }
}