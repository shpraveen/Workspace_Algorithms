package designPatterns.designPrinciples.openClosedPrinciple;

public interface Shape{
    public double calculateArea();
}

class Rectangle implements Shape{
    public double length = 10;
    public double width = 12;

    public double calculateArea(){
        return length * width;
    }

}

class Circle implements Shape{
    public double radius = 8.00;

    public double calculateArea(){
        return (22/7) * radius * radius;
    }

}

class CalculateArea {
    public double calculateShapeArea(Shape shape){
        return shape.calculateArea();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        CalculateArea ca = new CalculateArea();

        double areaCircle = ca.calculateShapeArea(circle);
        System.out.println("Area of Circle: "+areaCircle);

        double areaRectangle = ca.calculateShapeArea(rectangle);
        System.out.println("Area of Rectangle: "+areaRectangle);
    }

}
