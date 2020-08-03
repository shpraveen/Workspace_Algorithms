package designPatterns.creational.prototype.challenge;

import java.util.Hashtable;

public class BasicCarCache {

    private static Hashtable<String, BasicCar> basicCarMap = new Hashtable<String,BasicCar>();

    public static BasicCar getCar(String carName){
        BasicCar clone = null;
        BasicCar cachedBasicCar = basicCarMap.get(carName);
        try {
            clone=(BasicCar)cachedBasicCar.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    return clone;
    }

    public static void loadCache(){
        BasicCar nano_base = new Nano("Green Nano");
        nano_base.price=100000;
        basicCarMap.put("Green Nano", nano_base);

        BasicCar ford_base = new Nano("Ford Yellow");
        ford_base.price=500000;
        basicCarMap.put("Ford Yellow", ford_base);



    }

}
