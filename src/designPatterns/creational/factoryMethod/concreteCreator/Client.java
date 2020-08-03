package designPatterns.creational.factoryMethod.concreteCreator;

public class Client {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of the Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        //get an object of the RECTANGLE and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        //get an object of the SQUARE and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();

    }
}
