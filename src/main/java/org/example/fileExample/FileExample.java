package org.example.fileExample;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public void getFileExample() {
        File file = new File("src/main/resources/text.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }

}
