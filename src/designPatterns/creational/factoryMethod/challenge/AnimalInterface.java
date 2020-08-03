package designPatterns.creational.factoryMethod.challenge;

public interface AnimalInterface {

    void speak();
}

class Duck implements AnimalInterface{

    @Override
    public void speak() {
        System.out.println("Duck says Pack-Pack!! ");
    }
}

class Tiger implements AnimalInterface{

    @Override
    public void speak() {
        System.out.println("Tiger says Halum-Halum!! ");
    }
}