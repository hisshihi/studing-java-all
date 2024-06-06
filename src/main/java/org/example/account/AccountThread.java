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
        for (int i = 0; i < 2000; i++) {
            // Попытка захватить блокировки обоих аккаунтов.
            lockAccounts();
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
                // finally: Блокировки аккаунтов освобождаются независимо от того, была ли операция успешной.
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }

        }
    }

    // Этот метод пытается захватить блокировки обоих аккаунтов, чтобы избежать взаимоблокировки:
    private void lockAccounts() {
        while (true) {
            // Захватываем мониторы аккаунтов
            // tryLock(): Пытается захватить блокировку, возвращая true, если успешен, и false в противном случае.
            boolean fromAccountLock = accountFrom.getLock().tryLock();
            boolean toAccountLock = accountTo.getLock().tryLock();
            // Если обе блокировки захвачены, цикл прерывается.
            if (fromAccountLock && toAccountLock) {
                break;
            }
            // Если захвачена только одна блокировка, она освобождается, и цикл продолжается, чтобы снова попытаться захватить обе блокировки.
            if (fromAccountLock) {
                accountFrom.getLock().unlock();
            }
            if (toAccountLock) {
                accountTo.getLock().unlock();
            }
        }
    }
}
