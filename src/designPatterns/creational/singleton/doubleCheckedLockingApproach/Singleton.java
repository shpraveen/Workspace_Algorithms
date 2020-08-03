package designPatterns.creational.singleton.doubleCheckedLockingApproach;

public class Singleton {

    // the private reference to the one and only one instance
    private static volatile Singleton uniqueInstance = null;

    //an instance attribute
    private int data=0;

    /*
    *The private Singleton constructor
    *No client can instantiate a Singleton object!!
    */

    private Singleton(){}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {// we only synchronise first time through
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public void setData(int myData){
        data=myData;
    }

    public int getData(){
        return data;
    }
}
