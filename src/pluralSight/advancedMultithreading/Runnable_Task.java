package pluralSight.advancedMultithreading;

public class Runnable_Task {

    public static void main(String[] args) {

        Runnable task = () -> System.out.println("I am in Thread: "+Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {

            new Thread(task).start();

        }

    }


}
