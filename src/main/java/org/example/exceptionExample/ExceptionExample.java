package org.example.exceptionExample;

import java.io.FileNotFoundException;

public class ExceptionExample {

    public void unsafe(int value) throws FileNotFoundException {
        if (value > 0) {
            throw new FileNotFoundException();
        }
    }

}
