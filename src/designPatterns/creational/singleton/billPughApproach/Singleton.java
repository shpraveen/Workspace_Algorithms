package designPatterns.creational.singleton.billPughApproach;

public class Singleton {

    //an instance attribute
    private int data=0;

    /*
    *The private Singleton constructor
    *No client can instantiate a Singleton object!!
    */

    private static class SingletonHelper{

        private static final Singleton uniqueInstance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHelper.uniqueInstance;
    }

    public void setData(int myData){
        data=myData;
    }

    public int getData(){
        return data;
    }
}
