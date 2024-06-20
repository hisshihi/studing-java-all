package org.example;

import org.example.reflectionApiExample.ReflectionApiExample;
import org.example.reflectionApiExample.ReflectionUser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ReflectionApiExample apiExample = new ReflectionApiExample();

        apiExample.reflectionTest();
    }
}