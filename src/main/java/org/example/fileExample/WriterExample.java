package org.example.fileExample;

import java.io.*;

public class WriterExample {

    public void writerAndFile(File file) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

            fileWriter.append("Hello World!");
            fileWriter.newLine();
            fileWriter.append("from Java");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
