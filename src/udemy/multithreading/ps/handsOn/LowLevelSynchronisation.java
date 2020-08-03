package udemy.multithreading.ps.handsOn;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Processor5{

    private List<Integer> list = new LinkedList<Integer>();
    private final int LIMIT=10;
    private Object lock = new Object();

    public void produce() throws InterruptedException{

        int value =0;

        while(true){
            synchronized (lock){
                while(list.size()==LIMIT){
                    lock.wait();
                }

                list.add(value++);
                lock.notify();
            }
        }

    }


    public void consume() throws InterruptedException{

        Random random = new Random();

        while(true){
            synchronized (lock){
                while(list.size()==0){
                    lock.wait();
                }

                System.out.print("List Size is: "+list.size());
                int value = list.remove(0);
                System.out.println(", List value is: "+value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }

    }

}

public class LowLevelSynchronisation {

    public static void main(String[] args) throws InterruptedException {
        final Processor5 process = new Processor5();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
