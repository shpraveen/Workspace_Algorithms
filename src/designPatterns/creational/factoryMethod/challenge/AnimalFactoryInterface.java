package designPatterns.creational.factoryMethod.challenge;

public abstract class  AnimalFactoryInterface {

    public abstract AnimalInterface getAnimalType(String animalType) throws Exception;

}

class AnimalConcreteFactory extends AnimalFactoryInterface {

    public AnimalInterface getAnimalType(String animalType) throws Exception {
        switch (animalType) {
            case "Duck":
                return new Duck();

            case "Tiger":
                return new Tiger();

            default:
                throw new Exception("Animal Type: "+animalType+" cannot be instantiated !! ");
        }
    }
}