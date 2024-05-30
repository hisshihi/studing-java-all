package org.example.fileExample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.*;

public class FileTasks {

    private static Integer findMaxDigitsCount(String line) {
//        Устанавливаем счётчик
        int counter = 0;
        // Результирующие число
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
//            Проверяем, что элемент в строке является числом
            if (Character.isDigit(line.charAt(i))) {
//                Если является, то прибавляем счётчик
                counter++;
            } else {
//                Проверяем, что рузльтат меньше каунтера, если это так,
                // тогда к результату присваиваем кол-во
                if (result < counter) {
                    result = counter;
                }
                counter = 0;
            }
        }
        return result;
    }

    /*
     * Задан файл с текстом, найти и вывести в консоль все слова,
     * начинающиеся с гласной буквы
     * */
    public void task1(Path path) {

        String VOWELS = "уеыаоэяию";

        try (Scanner scanner = new Scanner(path)) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1) {
                    System.out.println(word);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Задан файл с текстом, найти и вывести в консоль все слова,
     * для который последняя буква одного слова совпадает с пурвой буквой
     * следующего слова
     * */
    public void task2(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            String prev = null;
            if (scanner.hasNext()) {
                prev = scanner.next();
            }
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (isEqualLastSymbolAndFirstSymbol(prev, current)) {
                    System.out.println(prev + " " + current);
                }
                prev = current;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEqualLastSymbolAndFirstSymbol(String prev, String current) {
        return prev.charAt(prev.length() - 1) == current.charAt(0);
    }

    /*
     * Задан файл с текстом. В каждой строке найти и вывести наибольшее кол-во цифр, идущих подряд
     * */
    public void task3(Path path) {
//        С помощью стрима итерируемся по файлу
        try {
            Files.readAllLines(path).stream()
                    .map(FileTasks::findMaxDigitsCount)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Задан файл с java-кодом. Прочитать текст программы из файла и
     * все слова public в объявлении атрибутово и методов класса заменить
     * на слово private. Результат сохранить в другой заранее созданный файл
     * */
    public void task4(Path path) {
        try {
//            Представляем наш файл в виде одной строки
            String stringValue = Files.readString(path);

            // Заменяем все public на private
            String result = stringValue.replace("public", "private");

//            Создаём новый файл
            String fileName = String.valueOf(path.getFileName());
            Path resultPath = Path.of("src", "main", "resources", fileName);
            // Записываем в файл всю строку
            Files.writeString(resultPath, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * Задан файл с java-кодом. Прочитать текст программы из файла и
     * записать в другой файл в обратном порядке символы каждой строки.
     * */
    public void task5(Path path) {
        String fileName = String.valueOf(path.getFileName());
        Path result = Path.of("src", "main", "resources", fileName);

//        Читаем файл построчно;
//        Files всегда удобнее для работы с потоками ввода - вывода
        // Нельзя забывать закрывать потоки
        try (Stream<String> lines = Files.lines(path);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(result, APPEND, WRITE)) {

//            Создаём StringBuilder для revers
            lines.map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    // Применяем изменения к каждой строке
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
