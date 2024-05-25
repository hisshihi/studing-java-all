package org.example.exceptionExample;

public class CustomException extends Exception{

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
