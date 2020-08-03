package pluralSight.advancedMultithreading;

import java.util.concurrent.*;

public class Callable_Future_ExceptionHandling {

    public static void main(String[] args) throws InterruptedException, ExecutionException,TimeoutException {


        Callable<String> task =() -> {
            //Thread.sleep(250);
            throw new IllegalStateException("I am in Thread: "+Thread.currentThread().getName());

           // return "I am in Thread: "+Thread.currentThread().getName();

        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 100; i++) {

                Future<String> future = executorService.submit(task);
                System.out.println("I Get: " + future.get());

            }
        }
        finally {
            executorService.shutdown();
        }


    }


}
