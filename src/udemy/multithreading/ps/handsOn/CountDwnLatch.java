package udemy.multithreading.ps.handsOn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor2 implements Runnable{

    private CountDownLatch latch;
    public Processor2(CountDownLatch latch) {
        this.latch=latch;
    }

    public void run(){

        System.out.println(" *** Started ***");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();

    }


}


public class CountDwnLatch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService exec = Executors.newFixedThreadPool(3);

        for (int i = 0; i <3 ; i++) {
            exec.submit(new Processor2(latch));
        }

        try {
           // latch.await();
            latch.await(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("***Completed***");
    }
}
