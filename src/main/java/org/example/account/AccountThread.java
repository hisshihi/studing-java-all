package org.example.account;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    // Синхронизируем для захвата мониторов у двух методов и снимаем и зачисляем 10
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }
}
