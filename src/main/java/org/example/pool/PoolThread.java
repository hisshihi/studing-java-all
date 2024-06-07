package org.example.pool;

import java.util.Optional;
import java.util.Queue;

public class PoolThread extends Thread{

    private final Queue<Runnable> tasks;

    public PoolThread(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            // Пустая задача
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                // Если задача не пустая тогда забираем таску
                if (!tasks.isEmpty()) {
                    task = Optional.of(tasks.remove());
                }
            }
            task.isPresent(Runnable::run);
        }
    }
}
