package pluralSight.advancedMultithreading;
// There is a very little chance of getting counter value 0 due to race condition
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RaceConditionOnSimpleAtomicCounter {
    private static int counter=0;

    public static void main(String[] args) {

        class Incrementer implements Runnable{

            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    counter++;
                }
            }
        }

        class Decrementer implements Runnable{
            @Override
            public void run() {
                for(int i =0; i< 1000;i++){
                    counter--;
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Future<?>> futures = new ArrayList<>();

        try{
            for (int i = 0; i < 4; i++) {
                futures.add(executorService.submit(new Incrementer()));
            }

            for (int i = 0; i < 4; i++) {
                futures.add(executorService.submit(new Decrementer()));
            }

            futures.forEach(
                    future -> {
                        try{
                            future.get();
                        }catch(InterruptedException | ExecutionException e){
                            System.out.println(e.getMessage());
                        }

                    }


            );
            System.out.println("Counter :: "+counter);
        }finally{
            executorService.shutdown();
        }


    }

}
