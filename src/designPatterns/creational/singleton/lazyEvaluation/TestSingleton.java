package designPatterns.creational.singleton.lazyEvaluation;

public class TestSingleton {
    public static void main(String[] args) {

        Singleton s = Singleton.getInstance();

        //set the Data
        s.setData(100);

        System.out.println("First Reference: "+s);
        System.out.println("Singleton data value is: "+s.getData());

        //get another reference to the Singleton to check if it is the same
        s = null;

        s = Singleton.getInstance();

        System.out.println("\nSecond Reference: "+s);
        System.out.println("Singleton data value is: "+s.getData());

    }

}
