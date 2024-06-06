package org.example.account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private static int generator = 1;
    private int id;
    private int money;
//    Создаём объект Lock чтобы избежать Dead lock
    private final Lock lock = new ReentrantLock();

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

//    Зачисление средств
    public void add(int money) {
        this.money += money;
    }

    // Снятие средств
    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    /*
    * Этот метод возвращает объект Lock,
    * связанный с аккаунтом. Этот объект используется для синхронизации доступа к аккаунту
    * */
    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
