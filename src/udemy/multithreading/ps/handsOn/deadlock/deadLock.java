package udemy.multithreading.ps.handsOn.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner6{

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    public void firstThread() throws InterruptedException{

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
           // lock1.lock();
            //lock2.lock();
            acquireLock(lock1,lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally{
                lock1.unlock();
                lock2.unlock();
            }
        }

    }

    public void secondThread() throws InterruptedException{

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            //lock2.lock();
            //lock1.lock();
            acquireLock(lock2,lock1);

            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }
            finally{
                lock2.unlock();
                lock1.unlock();
            }
        }

    }

    // To avoid Deadlock
    private void acquireLock(Lock firstLock, Lock secondLock) {
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {

                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();

            } finally {

                if (gotFirstLock && gotSecondLock) {
                    return;
                }

                if (gotFirstLock) {
                    firstLock.unlock();
                }
                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }

        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }

}

public class deadLock {

    public static void main(String[] args) throws Exception {
        final Runner6 runner = new Runner6();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished();
    }

}
