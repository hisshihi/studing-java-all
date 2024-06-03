package org.example;

import org.example.threadDemo.SimpleThread;
public class Main {
    public static void main(String[] args) {

        SimpleThread simpleThread = new SimpleThread();
//        Запуск потока
        simpleThread.start();
//        Эта строка обозначает, что этот поток будет ждать, пока simpleThread не выполнит свою работу
        try {
            simpleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Обозначает - "как только сможешь остановится, то остановись"
        simpleThread.interrupt();
        System.out.println(Thread.currentThread().getName());

    }
}