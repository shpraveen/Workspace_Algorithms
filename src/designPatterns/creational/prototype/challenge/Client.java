package designPatterns.creational.prototype.challenge;

public class Client {

    public static void main(String[] args) {
        System.out.println("*** Prototype Pattern Demo ***");
        BasicCarCache.loadCache();

        BasicCar bc1 = (BasicCar)BasicCarCache.getCar("Green Nano");
        bc1.price= bc1.price+BasicCar.setPrice();

        System.out.println("Car is: "+bc1.getModelName()+"  and price is "+bc1.price);

        BasicCar bc2 = (BasicCar)BasicCarCache.getCar("Ford Yellow");
        bc2.price= bc2.price+BasicCar.setPrice();
        System.out.println("Car is: "+bc2.getModelName()+"  and price is "+bc2.price);

    }
}
