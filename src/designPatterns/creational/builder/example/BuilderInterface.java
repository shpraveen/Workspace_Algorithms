package designPatterns.creational.builder.example;

public interface BuilderInterface {

    void buildBody();
    void insertWheels();
    void addHeadLights();
    Product getVehicle();

}
//Concrete Builder class

class Car implements BuilderInterface{

    private Product product = new Product();

    @Override
    public void buildBody(){
        product.add("This is a body of a Car");
    }
    @Override
    public void insertWheels(){
        product.add("4 Wheels are added");

    }

    @Override
    public void addHeadLights() {
        product.add("2 Headlights are added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}

class MotorCycle implements BuilderInterface{

    private Product product = new Product();
    @Override
    public void buildBody(){
        product.add("This is a body of a Car");
    }
    @Override
    public void insertWheels(){
        product.add("2 Wheels are added");

    }

    @Override
    public void addHeadLights() {
        product.add("1 Headlights are added");
    }

    @Override
    public Product getVehicle() {
        return product;
    }


}