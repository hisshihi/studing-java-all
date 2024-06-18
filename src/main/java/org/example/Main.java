package org.example;

import org.example.reflectionApiExample.ReflectionApiExample;
import org.example.reflectionApiExample.ReflectionUser;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ReflectionApiExample apiExample = new ReflectionApiExample();

        ReflectionUser user = new ReflectionUser(21L, "Hiss");
        ReflectionUser arina = new ReflectionUser(21L, "Arina");
        apiExample.getUserId(arina);
        apiExample.getUserName(arina);
        apiExample.getAnAccessModifier(arina);
        apiExample.getUserMethods(user);
    }
}