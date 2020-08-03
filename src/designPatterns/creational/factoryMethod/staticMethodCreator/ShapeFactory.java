package designPatterns.creational.factoryMethod.staticMethodCreator;

public class ShapeFactory {

    // use getShape method to get object of type Shape
    public static Shape getShape(String shapeType){

        if(shapeType == null)
            return null;
        else if(shapeType == "CIRCLE")
            return new Circle();
        else if(shapeType == "RECTANGLE")
            return new Rectangle();
        else if(shapeType == "SQUARE")
            return new Square();
        return null;
    }

}
