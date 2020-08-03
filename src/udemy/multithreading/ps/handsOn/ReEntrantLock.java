package udemy.multithreading.ps.handsOn;


import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 class Runner2{

    private int count=0;
    private Lock lock =new  ReentrantLock();
    private Condition cond = lock.newCondition();
    public void increment(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public void firstThread() throws InterruptedException{

        lock.lock();

        System.out.println("Waiting !!");
        cond.await();
        System.out.println("Woken Up !!");

        try {
            increment();
        }
        finally{
        lock.unlock();}
    }

    public void secondThread() throws InterruptedException{

        Thread.sleep(100);
        lock.lock();

        System.out.println("Press Return Key !!");
        new Scanner(System.in).nextLine();
        System.out.println("Return key Pressed!!");
        cond.signal();
        try {
            increment();
        }
        finally{
            lock.unlock();}

    }
    public void finished(){

        System.out.println("Count is : "+count);
    }

}


public class ReEntrantLock {

    public static void main(String[] args) throws InterruptedException {
        final Runner2  runner = new Runner2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
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
