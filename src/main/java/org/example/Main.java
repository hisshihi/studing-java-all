package org.example;

import org.example.fileExample.OutputExample;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        File file = Path.of("src", "main", "resources", "output.txt").toFile();
        new OutputExample().outputInFile(file);

    }
}