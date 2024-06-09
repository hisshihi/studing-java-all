package org.example.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public void getThreadPoolDemo() {
        // Создаёт определённое кол-во потоков
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // Отправка задачи в пул потоков
        // Future используется для получения результата выполнения задачи или отслеживания ее состояния
        Future<Integer> future = executorService.submit(() -> {
            // Делаем так, что задача будет выполняться дольше
            Thread.sleep(2000L);
            System.out.println("It`s callable");
            return 1;
        });

        try {
            System.out.println("Result: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Завершение работы пула
        executorService.shutdown();
        // Ожидание завершения всех задач
        try {
            executorService.awaitTermination(1L, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("class end");


    }

    public void sheduleExecutorServiceDemo() {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
//        Отправляем задачу на выполнение
//        threadPool.schedule(() -> System.out.println("OK"), 3L, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK"), 2l, 4L, TimeUnit.SECONDS);

//        threadPool.shutdown();
//        try {
//            threadPool.awaitTermination(1L, TimeUnit.HOURS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
