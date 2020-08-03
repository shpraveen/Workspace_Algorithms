package udemy.multithreading.ps.handsOn;

class Runner1 implements Runnable{

    public void run(){

        for (int i = 0; i <10; i++) {
            System.out.println("Hello Way 2: "+i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadWay2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());

        t1.start();

    }

}
