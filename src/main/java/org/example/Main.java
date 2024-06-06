package org.example;

import org.example.account.Account;
import org.example.account.AccountThread;

public class Main {
    public static void main(String[] args) {

        Account account1 = new Account(20000);
        Account account2 = new Account(20000);

        AccountThread accountThread1 = new AccountThread(account1, account2);
        AccountThread accountThread2 = new AccountThread(account2, account1);

        accountThread1.start();
        accountThread2.start();

        try {
            accountThread1.join();
            accountThread2.join();

            System.out.println(account1);
            System.out.println(account2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}