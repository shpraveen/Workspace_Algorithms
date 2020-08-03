package udemy.multithreading.ps.handsOn;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
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

    public static void producer() throws InterruptedException {

        Random random = new Random();
        while(true){
            queue.put(random.nextInt(100));
        }
    }

    public static void consumer() throws InterruptedException {

    Random random =new Random();

    while(true){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(10)==0){

            Integer value = queue.take();
            System.out.println("Taken Value: "+value+ " Queue Size: "+queue.size());
        }

    }

    }
}
