package pluralSight.advancedMultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
using await method with time
if(!isEmpty.await(1,TimeUnit.MILLISECONDS)){
                                throw new TimeoutException("Consumer TimeOut");
                            }

                            it will return false and will halt the thread execution by throwing the exception

*/

public class ProducerConsumerSettingTimeOuts {

    public static void main(String[] args) throws InterruptedException{

        List<Integer> buffer = new ArrayList<>();

        Lock lock = new ReentrantLock();
        Condition isEmpty = lock.newCondition();
        Condition isFull = lock.newCondition();


        class Consumer implements Callable<String>{

            public String call() throws InterruptedException, TimeoutException{

                int count =0;

                while(count++ < 50 ){
                    try {
                        lock.lock();
                        while (buffer.isEmpty()) {
                            //wait
                            if(!isEmpty.await(1,TimeUnit.MILLISECONDS)){
                                throw new TimeoutException("Consumer TimeOut");
                            }

                        }

                        buffer.remove(buffer.size() - 1);
                        //signal
                        isFull.signalAll();
                    }
                    finally {
                        lock.unlock();
                    }


                }
            return "Consumed: "+(count - 1);
            }

        }

        class Producer implements Callable<String>{

            public String call() throws InterruptedException{

                int count =0;

                while(count++ < 50){
                    try {
                        lock.lock();
                        int i = 10/0;// to throw exception
                        while (buffer.size()==50) {
                            //wait
                            isFull.await();
                        }
                        buffer.add(buffer.size() + 1);
                        //signal
                        isEmpty.signalAll();
                    }
                    finally {
                        lock.unlock();
                    }


                }

                return "Produced: "+(count - 1);
            }
        }

        List<Producer> producers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            producers.add(new Producer());
        }

        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            consumers.add(new Consumer());
        }

        System.out.println("Producers and Consumers Launched!");

        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        producersAndConsumers.addAll(producers);
        producersAndConsumers.addAll(consumers);

        ExecutorService executer = Executors.newFixedThreadPool(8);
        try{

            List<Future<String>> futures = executer.invokeAll(producersAndConsumers);

            futures.forEach(
                    future -> {
               try {
                   System.out.println(future.get());
                }catch (InterruptedException | ExecutionException e){
                   System.out.println("Exception: "+e.getMessage());
               }
            }


        );

        }finally {
            executer.shutdown();
            System.out.println("Executor service shutdown");
        }

    }

}
