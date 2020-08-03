package udemy.multithreading.ps.handsOn;


class Runner extends Thread{

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello Thread "+i);
        }
    }

}

public class ThreadWay1 {

    public static void main(String[] args) {

        Runner r1 = new Runner();
        r1.start();

        Runner r2 = new Runner();
        r2.start();


    }

}

