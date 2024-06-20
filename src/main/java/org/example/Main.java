package org.example;

import org.example.reflectionApiTasks.Car;
import org.example.reflectionApiTasks.ReflectionApiTasks;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Corolla");
        ReflectionApiTasks apiTasks = new ReflectionApiTasks();
        System.out.println(apiTasks.task1(car));

    }
}