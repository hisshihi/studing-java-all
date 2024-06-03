package org.example.threadDemo;

public class Counter {

    private int count;

    private static String description;

    public static void init() {
        Class<Counter> counterClass = Counter.class;
        synchronized (counterClass) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    /*
     * Синхронизация гарантирует, что блок кода будет использоваться только одним потоком одновременно,
     * что делает метод атомарным.
     * У синхронизированного метода есть монитор, который показывает, захвачен ли он потоком или нет.
     * Когда монитор показывает, что метод не захвачен, другой поток может занять этот метод.
     *
     * Существует два способа синхронизации:
     * 1. Использование ключевого слова synchronized
     * 2. Использование синхронизированного блока
     * this обозначает ссылку на текущий объект.
     */

    // Ключевое слово synchronized обозначает, что одновременно этот метод может использовать только один поток.
    public synchronized void increment() {
        this.count++;
    }

    // Синхронизированный блок внутри метода.
    public void decrement() {
        synchronized (this) {
            this.count--;
        }
    }

    public int getCount() {
        return count;
    }

}
