package org.example.threadPractice;

import java.util.Queue;

public class ProducerThread implements Runnable {

    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() < 10) {
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("producer adds value: " + random + ". Size: " + list.size());
                } else {
                    System.out.println("producer does nothing");
                }
                list.notifyAll();
                try {
                    int randomWaitValue = RandomUtil.getRandom(5);
                    System.out.println("producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
