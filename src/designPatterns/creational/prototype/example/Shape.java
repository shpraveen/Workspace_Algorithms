package designPatterns.creational.prototype.example;

abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    abstract void draw();

    public String getType(){
        return type;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

//no @Override means we are not overriding clone
    protected Object clone() {
        Object clone = null;
        try {
           clone = super.clone();
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }

}
class Rectangle extends Shape{

    public Rectangle(){
        type="Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() Method !!");
    }
}

class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() Method !!");
    }
}

class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() Method !!");
    }
}

