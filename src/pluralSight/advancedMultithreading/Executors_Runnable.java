package pluralSight.advancedMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executors_Runnable {

    public static void main(String[] args) {

        Runnable task = () -> System.out.println("I am in Thread: "+Thread.currentThread().getName());

        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {

            //new Thread(task).start();
            executor.submit(task);

        }
        executor.shutdown();
    }


}
