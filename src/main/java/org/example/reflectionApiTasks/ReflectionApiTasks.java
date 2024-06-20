package org.example.reflectionApiTasks;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReflectionApiTasks {

    /*
    * Создать класс Car с полями brand and model.
    * Создать аннотации Table (принимает название схемы и таблицы в бд) и Column
    * (принимает название колонки в таблице бд). Пометить класс аннотацией Table и поля аннотацией Column.
    * Написать программу, принимающую объект класс Car с проинициализированными полями и составляющую запрос
    * "INSERT" в виде строки на основании данных объекта.
    * Пример: дан объект Car car = new Car("Toyota", "Corolla");
    * Программа, принимающая этот объект, должна вывести в консоль строку:
    * "INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');"
    *
    * */
    public String task1(Car car) {
        String template = "INSERT INTO %s.%s (%s) VALUE (%s);";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();

        String fieldNames = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::value)
                .collect(Collectors.joining(", "));

        String fieldValues = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .sorted(Comparator.comparing(Field::getName))
                .map(field -> {
                    try {
                        return getMethod(car, field);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .peek(field -> field.setAccessible(true))
                .map(method -> {
                    try {
                        return method.invoke(car);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(", "));

        return String.format(template, table.schema(), table.value(), fieldNames, fieldValues);
    }

    private static Method getMethod(Car car, Field field) throws NoSuchMethodException {
        return car.getClass().getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
    }

}
