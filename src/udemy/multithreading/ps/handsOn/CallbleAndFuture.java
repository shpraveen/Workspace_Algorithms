package udemy.multithreading.ps.handsOn;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class CallbleAndFuture {

    public static void main(String[] args) throws InterruptedException{

        ExecutorService exec = Executors.newCachedThreadPool();

        Future<Integer> future = exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if(duration > 2000){
                    throw new IOException("Sleeping for too long!!");
                }

                System.out.println("*** Starting ***");

                Thread.sleep(duration);

                System.out.println("*** Finished ***");

                return duration;
            }
        });

        exec.shutdown();

        try {
            System.out.println("Result is: "+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch(ExecutionException e){
            IOException ex =(IOException) e.getCause();
            System.out.println(ex.getMessage());
        }

    }

}
