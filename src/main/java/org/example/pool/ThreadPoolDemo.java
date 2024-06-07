package org.example.pool;

import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public void getThreadPoolDemo() {
        // Создаёт один поток
        Executors.newSingleThreadExecutor();
        // Создаёт определённое кол-во потоков
        Executors.newFixedThreadPool(5);
        /*
        * Создаёт безграничное кол-во потоков, но кэширует их
        * то есть если мы создали 5 потоков а потом ещё 4 то эти 4 потока возьмутся из кэша
        * А если мы к примеру хотим создать 6 потоков, то возьмутся предыдущие 5 и создастся ещё 1 поток
        * */
        Executors.newCachedThreadPool();
        // Запускаем какую-то задачу с задержкой
        Executors.newScheduledThreadPool(3);
        // Получаем все свободные процессы которые доступны на компьютере, то есть он береёт оптимальное кол-во потоков.
        Executors.newWorkStealingPool();

    }

}
