package org.example.fileExample;

import java.io.*;
import java.util.stream.Collectors;

public class ReaderExample {

    public void readTextFile(File file) {
        // Боле удобный вывод и работа с текстовыми файлами
        // А также он буферизует наш поток, чтобы быстрее получать данные
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            String collect = fileReader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
