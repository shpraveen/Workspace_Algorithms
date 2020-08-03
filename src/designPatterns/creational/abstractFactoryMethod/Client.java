package designPatterns.creational.abstractFactoryMethod;

public class Client {

    public static void main(String[] args) {

        //get ShapeFactory
        AbstractFactory shapeFactory=FactoryProducer.getFactory("SHAPE");

        Shape shape = shapeFactory.getShape("Circle");
        shape.draw();

        Shape shape1 = shapeFactory.getShape("Square");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();

        //get ColorFactory
        AbstractFactory colorFactory =FactoryProducer.getFactory("COLOR");

        Color color =colorFactory.getColor("Red");
        color.fill();

        Color color1 =colorFactory.getColor("Green");
        color1.fill();

        Color color2 =colorFactory.getColor("Yellow");
        color2.fill();


    }
}
