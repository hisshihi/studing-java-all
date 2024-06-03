package org.example;

import org.example.threadDemo.SimpleRunnable;
import org.example.threadDemo.SimpleThread;
public class Main {
    public static void main(String[] args) {

        SimpleThread simpleThread = new SimpleThread();

        SimpleRunnable simpleRunnable = new SimpleRunnable();
        Thread runnbleThread = new Thread(new SimpleRunnable());
        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

//        Запуск потока
        simpleThread.start();
        runnbleThread.start();
        lambdaThread.start();
//        Эта строка обозначает, что этот поток будет ждать, пока simpleThread не выполнит свою работу
        try {
            simpleThread.join();
            runnbleThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Обозначает - "как только сможешь остановится, то остановись"
        simpleThread.interrupt();
        System.out.println(Thread.currentThread().getName());

    }
}