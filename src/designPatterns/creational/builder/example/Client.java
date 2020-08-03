package designPatterns.creational.builder.example;

public class Client {
    public static void main(String[] args) {
        System.out.println("*** Builder Pattern Demo ***");

        Director director = new Director();

        BuilderInterface carBuilder = new Car();
        BuilderInterface motorBuilder = new MotorCycle();

        //Making a car
        director.construct(carBuilder);
        Product p1 = carBuilder.getVehicle();
        p1.show();

        //Making a motor cycle
        director.construct(motorBuilder);
        Product p2 = motorBuilder.getVehicle();
        p2.show();
    }

}
