package org.example.threadDemo;

public class VolatileDemo {


    /*
    * volatile используется только для примитивных типов
    *
    * volatile — это ключевое слово в Java, которое используется для обозначения переменных,
    * к которым могут обращаться несколько потоков.
    * Оно гарантирует, что изменения значения переменной сразу становятся видимыми для всех потоков.
    * Это предотвращает кеширование значения переменной в регистрах или в локальной памяти потока и
    * обеспечивает его чтение из основной памяти каждый раз, когда к нему обращаются.
    *
    * В целом обозначает, что к методу volatile нельзя применять какие-либо операции
    * */
    private static volatile boolean flag;
    private int count;

    public void optionsWithFlag() {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                count++;
                System.out.println("все еще ложь");
            }
        });
        thread1.start();

        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("флаг установлен");
            System.out.println("Значение count - " + getCount());
        });
        thread2.start();
    }

    public int getCount() {
        return count;
    }

}
