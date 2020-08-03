package designPatterns.creational.abstractFactoryMethod;

public interface Color {

    void fill();
}

class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() Method !!");
    }
}

class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() Method !!");
    }
}
class Yellow implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Yellow::fill() Method !!");
    }
}