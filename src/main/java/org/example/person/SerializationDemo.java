package org.example.person;

import org.example.SerializationAndDeserialization.People;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {

    public void getSerializationDemo(Path path) {
//        writeObject(path);
//        Десериализация - это создание объекта из массива байт
        inputObject(path);
    }

    private static void inputObject(Path path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()));) {
            Object object = objectInputStream.readObject();
            if (object instanceof People) {
                People people = (People) object;
                System.out.println(people);
            } else {
                System.out.println("Десериализованный объект не является экземпляром People");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeObject(Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));) {
            People denis = new People(21, "Denis");
            objectOutputStream.writeObject(denis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
