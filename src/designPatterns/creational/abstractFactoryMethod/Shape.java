package designPatterns.creational.abstractFactoryMethod;

public interface Shape {
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() Method !!");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() Method !!");
    }
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() Method !!");
    }
}