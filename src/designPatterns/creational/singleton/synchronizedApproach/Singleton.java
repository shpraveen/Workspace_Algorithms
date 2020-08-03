package designPatterns.creational.singleton.synchronizedApproach;

public class Singleton {

    // the private reference to the one and only one instance
    private static Singleton uniqueInstance = null;

    //an instance attribute
    private int data=0;

    /*
    *The private Singleton constructor
    *No client can instantiate a Singleton object!!
    */

    private Singleton(){}

    //by synchronized keyword we force every thread to wait its turn before it can enter the method
    public static synchronized Singleton getInstance(){
        if(uniqueInstance == null)
            uniqueInstance =  new Singleton();

        return uniqueInstance;
    }

    public void setData(int myData){
        data=myData;
    }

    public int getData(){
        return data;
    }
}
