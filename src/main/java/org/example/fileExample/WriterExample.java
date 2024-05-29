package org.example.fileExample;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class WriterExample {

    public void writerAndFile(File file) {
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
//
//            fileWriter.append("Hello World!");
//            fileWriter.newLine();
//            fileWriter.append("from Java");
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        /*
        * Более новые и удобные способы работы с файлами.
        * */

        try {
            Files.write(file.toPath(), List.of("Hello World", "Java"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try (BufferedWriter fileRider = Files.newBufferedWriter(file.toPath())) {
//
//            fileRider.append("Hello");
//            fileRider.newLine();
//            fileRider.append("Java!");
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
