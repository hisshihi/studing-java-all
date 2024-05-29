package org.example.fileExample;

import java.io.*;

public class OutputExample {

    public void outputInFile(File file) {
        //            Флаг true обозначает, что файл не будет перезаписываться
//        BufferedOutputStream обеспечивает буферизацию
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {

//            То, что хотим записать
            String value = "Hello World!";

            outputStream.write(value.getBytes());
//            Используем для переноса строки
            outputStream.write(System.lineSeparator().getBytes());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
