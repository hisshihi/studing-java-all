package org.example;

import org.example.conllectinPractice.Practice;
import org.example.exceptionExample.ExceptionExample;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        ExceptionExample exceptionExample = new ExceptionExample();
        try {
            exceptionExample.unsafe(10);
        } catch (FileNotFoundException exception) {
//            handle exception
//            Видим весь стек ошибки
            exception.printStackTrace();
        } finally {
//            Этот блок выполняется всегда
            System.out.println("finally");
        }

        System.out.println(exceptionExample.finallyTest());

    }
}