package org.example.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{

    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску");
//        Ожиданем пока остальные детали не будут сделаны
        /*
        * Поток ожидает, пока счётчик CountDownLatch не станет равным нулю,
        * после чего выводит сообщение о запуске ракеты.
        * */
        try {
            countDownLatch.await();
            System.out.println("Пуск!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
