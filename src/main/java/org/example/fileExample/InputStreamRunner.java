package org.example.fileExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {

    public void readFile() {
//        Указываем путь до файла в независимости от платформы на которой работаем
        File file = Path.of("src", "main", "resources", "text.txt").toFile();
        // Чтение файла и закртие его потока по завершению
        try (FileInputStream inputStream = new FileInputStream(file)) {
//            Получаем поток данных из файла
//            byte[] bytes = inputStream.readAllBytes();
//
//            // Конвертируем их в строку
//            String stringValue = new String(bytes);
//            System.out.println(stringValue);

//            Чтение файла порционно
            byte[] bytes = new byte[inputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
