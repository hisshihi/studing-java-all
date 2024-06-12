package org.example.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    // Очередь касс
    private final Semaphore cashboxes;

    // Конструктор для инициализации очереди касс
    public BuyerThread(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
//            Получаем монитор
            cashboxes.acquire();
            System.out.println(Thread.currentThread().getName() + " обслуживается в какой-то касса");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождает какую-то кассу");
            cashboxes.release();
            // Проверяем с помощью блока синхронизации, что только один поток может воспользоваться кассой
//            synchronized (cashboxQueue) {
//                while (true) {
//                    // Проверяет доступность касс
//                    if (!cashboxQueue.isEmpty()) {
//                        // Удаляем кассу из очереди касс для обслуживания покупателя
//                        Cashbox cashbox = cashboxQueue.remove();
//                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
//
//                        // Симуляция времени обслуживания
//                        // Также этот метод захватывает монитор для потока
//                        cashboxQueue.wait(5L);
//
//                        // Сообщение об освобождении кассы
//                        System.out.println(Thread.currentThread().getName() + " освобождает кассу " + cashbox);
//                        // Возвращаем кассу обратно в очередь
//                        cashboxQueue.add(cashbox);
//
//                        // Уведомляет все потоки, что касса освободилась
//                        cashboxQueue.notifyAll();
//                        break; // Завершаем работу текущего потока
//                    } else {
//                        // Если нет свободных касс, покупатель ждет
//                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу ");
//                        cashboxQueue.wait(); // Ожидание перед повторной проверкой очереди. Ждём сколько нужно пока касса не освободится
//                    }
//                }
//            }
        } catch (InterruptedException e) {
            e.printStackTrace(); // Обработка прерывания потока
        }
    }
}
