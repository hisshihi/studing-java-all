package org.example;

import org.example.queue.BuyerThread;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Semaphore cashboxes = new Semaphore(2, true);

        List<Thread> threads = Stream.of(
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes),
                new BuyerThread(cashboxes)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread:
            threads ) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}