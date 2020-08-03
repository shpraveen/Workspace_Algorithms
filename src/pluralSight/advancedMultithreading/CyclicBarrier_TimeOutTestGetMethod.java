package pluralSight.advancedMultithreading;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrier_TimeOutTestGetMethod {

    public static void main(String[] args) {

        class Friend implements Callable<String> {
            private CyclicBarrier barrier;

            public Friend(CyclicBarrier barrier) {
                this.barrier = barrier;
            }

            public String call() throws Exception {
                try{
                Random random = new Random();

                Thread.sleep(random.nextInt(20) * 10 + 100);
                System.out.println("I Just Arrived, waiting for others!! ");

                //barrier.await(5, TimeUnit.SECONDS);
                barrier.await();
                System.out.println("Lets go!! ");
                return "OK";
            }catch(InterruptedException e){
                    System.out.println("Interrupted!!");
                }
                return "NOK";
            }

        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //CyclicBarrier barrier = new CyclicBarrier(4);
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier Opening!!"));
        List<Future<String>> futures = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                Friend friend = new Friend(barrier);
                futures.add(executorService.submit(friend));
            }

            futures.forEach(
                    future -> {
                        try {
                            future.get(250,TimeUnit.MILLISECONDS);
                        } catch (InterruptedException | ExecutionException e) {
                            e.getMessage();
                        }catch(TimeoutException ex){
                            System.out.println("Time Out");
                            future.cancel(true);
                        }

                    }

            );

        } finally {
            executorService.shutdown();
        }

    }
}


