package org.example.threadTasks;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ThreadTasks {

    /*
    * 1. Написать программу, бесконечно считывающую пользовательские числа из консоли.
    * Эти числа представляют собой кол-во секунд.
    * При каждом вводе числа, должна создаваться задача,
    * которая засыпает на введённое число секунд и затем
    * выводит "Я спал N секунд".
    * Одна нужно сделать так, чтобы все задачи выполнялись в
    * одном и том же потоке в порядке ввода.
    * Т.е. в программе есть 2 потока: главный и поток для выполнения всех задач по очереди.
    * При вводе отрицательного числа программа должна завершать свою работу.
    * Второе решение - несколько потоков в пуле. Посчитать кол-во
    * обработанных задач каждым потоком.
    * */
    public void task1() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();

            if (seconds < 0) {
                break;
            } else {
                threadPool.submit(() -> {
                    Integer counter = threadLocal.get();
                    threadLocal.set(counter == null ? 1 : ++counter);
                    System.out.println(String.format("Поток `%s`, задач: `%d`", Thread.currentThread().getName(), threadLocal.get()));
                    try {
                        Thread.sleep(seconds * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Поток `%s` спал `%d` секунд", Thread.currentThread().getName(), seconds);
                    System.out.println();
                });
            }
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * Задан маасив случайных чисел (от 1 до 300)
    * случайно длины (до 1 млн элементов.
    * Найти максимальный элемент в массиве двумя способами: в
    * одном потоке и используя 10 потоков.
    * Сравнить затраченное в обоих случаях время.
    * */
    public void task2() {
        int[] values = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300) + 1;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        trackTime(() -> {
            try {
                return findMaxParallel(values, executorService);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            return Integer.MIN_VALUE;
        });
        trackTime(() -> findMax(values));

        executorService.shutdownNow();

    }

    private static int trackTime(Supplier<Integer> task) {
        // Запоминаем время начала
        long startTime = System.currentTimeMillis();
        // Выполняем задачу и получаем результат
        int result = task.get();
        // Выводим результат и время выполнения
        System.out.println(result + " : " + (System.currentTimeMillis() - startTime));
        return result;
    }

    private static int findMax(int[] values) {
        // Находим максимальное значение в массиве последовательным способом
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        // Находим максимальное значение в массиве параллельным способом
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)
        ).get();
    }

}
