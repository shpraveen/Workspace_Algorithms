package pluralSight.advancedMultithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLockFixing {

    private Map<Long,String> cache = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock=lock.readLock();
    private Lock writeLock= lock.writeLock();

    public String put(Long key ,String value){
        writeLock.lock();
        try {
            return cache.put(key, value);
        }finally
        {
            writeLock.unlock();
        }
    }

    public String get(Long key){
        readLock.lock();
        try{
            System.out.println(" Get Method: "+cache.get(key));
            return cache.get(key);
        }finally{
            readLock.unlock();
        }

    }

    public static void main(String[] args) {

        CacheWithReadWriteLockFixing cache = new CacheWithReadWriteLockFixing();

        class Producer implements Callable<String>{
            private Random random = new Random();
            public String call() throws Exception{

                while(true){

                    long key = random.nextInt(1_000);
                    cache.put(key, Long.toString(key));

                    if(cache.get(key)==null){
                        System.out.println("Key "+key+ " has not been put in Map!!");
                    }
                }

            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        System.out.println("Adding value ...");
        try{
            for (int i = 0; i < 8; i++) {
                executorService.submit(new Producer());
                System.out.println("Map Vale "+i);

            }
        }finally {
            executorService.shutdown();
        }

    }


}
