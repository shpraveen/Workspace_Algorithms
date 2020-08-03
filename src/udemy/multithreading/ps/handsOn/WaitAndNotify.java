package udemy.multithreading.ps.handsOn;


import java.util.Scanner;

class Process4{
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread Running!");
            wait();
            System.out.println("Resumed!");
        }

    }

    public void consume() throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("waiting for Return Key");
            scan.nextLine();
            System.out.println("Return Key Pressed");
            notify();
        }
    }
}

public class WaitAndNotify {

    static final Process4 process =new Process4();
    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
