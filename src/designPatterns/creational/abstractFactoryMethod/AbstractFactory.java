package designPatterns.creational.abstractFactoryMethod;

public abstract class AbstractFactory {

    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String shape) {

        if(shape == null)
            return null;
        else if(shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        else if(shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else if(shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;
    }

    @Override
    Color getColor(String color) {//here interface segregation is not follwed // for that need to create two abstarct classes or interfaces
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    Shape getShape(String shape) {//here interface segregation is not follwed // for that need to create two abstarct classes or interfaces

        return null;
    }

    @Override
    Color getColor(String color) {

        if(color == null)
            return null;
        else if(color.equalsIgnoreCase("RED")) {
            return new Red();
        }
        else if(color.equalsIgnoreCase("Green")) {
            return new Green();
        }
        else if(color.equalsIgnoreCase("Yellow")) {
            return new Yellow();
        }

        return null;
    }
}
