package org.example;

import org.example.fileExample.WriterExample;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        File file = Path.of("src", "main", "resources", "writer.poem").toFile();
        new WriterExample().writerAndFile(file);

    }
}