package com.michaldebicki;

public class Main {



    public static void main(String[] args) {

        NewBankAccount account = new NewBankAccount("12345-678",1000);

        //1 sposób
        Thread trThread1 = new Thread(){
            public void run() {
                synchronized (account) {
                    account.deposit(203.75);
                    account.withdraw(100);
                }
            }
        };

        Thread trThread2 = new Thread(){
            public void run() {
                synchronized (account) {
                    account.deposit(203.75);
                    account.withdraw(100);
                }
            }
        };

        //2 sposób Runnable

        Thread trThreadRunnable1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        });

        Thread trThreadRunnable2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        });

        trThread1.start();
        trThread2.start();
    }
}



