package org.example;

import org.example.latch.Rocket;
import org.example.latch.RocketDetail;
import org.example.latch.RocketDetailRunnable;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        /*
        * Создаётся CountDownLatch, инициализирующийся количеством деталей ракеты.
        * Это необходимо для синхронизации работы потоков.
        * */
        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
//        Создаётся пул потоков с фиксированным количеством потоков равным 4.
        ExecutorService executorService = Executors.newFixedThreadPool(4);

//        Ждём освобождения потоков и запускаем ракету
//        В пул потоков добавляется задача подготовки и запуска ракеты.
        executorService.submit(new Rocket(countDownLatch));
//        Запуск задач по подготовке деталей:
        /*
        * Каждая деталь ракеты создаётся в виде отдельной задачи (RocketDetailRunnable) и
        * добавляется в пул потоков.
        * */
        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRunnable(detail, countDownLatch))
                .forEach(executorService::submit);

//        Завершаем работу сервиса
        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}