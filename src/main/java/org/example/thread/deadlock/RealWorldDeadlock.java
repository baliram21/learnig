package org.example.thread.deadlock;

public class RealWorldDeadlock {

    static class Account {
        int balance = 1000;
        String name;

        Account(String name) {
            this.name = name;
        }

        synchronized void debit(Account to, int amount) {
            System.out.println(Thread.currentThread().getName()
                    + " locked " + this.name + " for debit");

            try { Thread.sleep(100); } catch (InterruptedException ignored) {}

            System.out.println(Thread.currentThread().getName()
                    + " trying to lock " + to.name + " for credit");

            synchronized (to) {
                this.balance -= amount;
                to.balance += amount;
                System.out.println("Transfer complete");
            }
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account("A1");
        Account a2 = new Account("A2");

        Thread t1 = new Thread(() -> a1.debit(a2, 100));
        Thread t2 = new Thread(() -> a2.debit(a1, 200));

        t1.start();
        t2.start();
    }
}
