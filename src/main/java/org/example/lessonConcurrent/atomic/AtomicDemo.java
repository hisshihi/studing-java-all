package org.example.lessonConcurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    /*
    * В Java Atomic относится к классам в пакете java.util.concurrent.atomic,
    * которые предоставляют атомарные операции для различных типов данных.
    * Эти классы были разработаны для обеспечения безопасности потоков и
    * выполнения операций без использования явной синхронизации.
    * */
    public void getAtomicDemo() {
        int value = 5;
        AtomicInteger atomicInteger = new AtomicInteger(value);
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);

        int addAndGet = atomicInteger.addAndGet(22);
        System.out.println(addAndGet);
    }

}
