package org.example.latch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable implements Runnable {

    private final RocketDetail rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetailRunnable(RocketDetail rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }

//    Имитируем подготовку деталей
    /*
    * Поток имитирует подготовку детали, ожидая 1 секунду,
    * после чего уменьшает счётчик CountDownLatch.
    * */
    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова " + rocketDetail);
//            Уменьшаем счётчик блокировки
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
