package udemy.multithreading.ps.handsOn;

import java.util.Scanner;

class Processor extends Thread{

    public volatile boolean running = true;

    @Override
    public void run() {
        while(running){
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}

public class VoltileKeyword {

    public static void main(String[] args) {
        Processor prc = new Processor();

        prc.start();

        System.out.println("Press Return to stop: ");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        prc.shutdown();
    }
}
