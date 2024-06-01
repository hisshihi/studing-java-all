package org.example.SerializationAndDeserialization;

import java.io.Serial;
import java.io.Serializable;

public class People implements Serializable {

    @Serial
    private static final long serialVersionUID = -5834929350747911757L;
//    transient указывает, что это поле не сериализуется
    private transient int age;
    private String firstName;

    public People(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
