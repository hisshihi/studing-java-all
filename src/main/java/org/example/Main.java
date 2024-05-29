package org.example;

import org.example.fileExample.InputStreamRunner;
import org.example.fileExample.ReaderExample;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        File file = Path.of("src", "main", "resources", "text.txt").toFile();
        new ReaderExample().readTextFile(file);

    }
}