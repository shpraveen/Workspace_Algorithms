package udemy.multithreading.ps.handsOn;

import java.util.concurrent.*;

class Connection{

    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);
    private int connections =0;

    private Connection(){

    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){

        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            doConnect();
        }
        finally{
            sem.release();
        }
    }
    public void doConnect(){

        synchronized (this){
            connections++;
            System.out.println("Current Connections: "+connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this){
            connections--;
        }
    }
}


public class Semphoress {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
