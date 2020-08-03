package designPatterns.creational.singleton.eagerEvaluation;

public class Singleton {

    private static Singleton uniqueInstantance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return uniqueInstantance;// as this already instantiated
    }

}
