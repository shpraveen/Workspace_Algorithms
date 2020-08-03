package designPatterns.creational.factoryMethod.abstractCreator;

public class Client {
    public static void main(String[] args) {

        Shape shape1 = new RectangleFactory().getShape();
        shape1.draw();

        Shape shape2 = new CircleFactory().getShape();
        shape2.draw();

        Shape shape3 = new SquareFactory().getShape();
        shape3.draw();
    }

}
