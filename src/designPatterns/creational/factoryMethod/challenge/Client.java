package designPatterns.creational.factoryMethod.challenge;

public class Client {

    public static void main(String[] args) throws Exception{

        System.out.println("***Factory Pattern Demo***\n");
        AnimalFactoryInterface animalFactory = new AnimalConcreteFactory();

        AnimalInterface duckType=animalFactory.getAnimalType("Duck");
        duckType.speak();

        AnimalInterface tigerType =animalFactory.getAnimalType("Tiger");
        tigerType.speak();

        AnimalInterface lionType = animalFactory.getAnimalType("Lion");
        lionType.speak();

    }
}
