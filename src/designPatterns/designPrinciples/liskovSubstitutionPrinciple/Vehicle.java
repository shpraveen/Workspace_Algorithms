package designPatterns.designPrinciples.liskovSubstitutionPrinciple;

public abstract class Vehicle {

    abstract int getSpeed();
    abstract int getCubicCapacity();
    void getGear(){
        System.out.println("No of Gear is: ");
    }

}

class Car extends Vehicle{

    @Override
    int getSpeed(){
        return 0;
    }

    @Override
    int getCubicCapacity() {
        return 0;
    }

    boolean sHatchBack(){
        return false;
    }
    }
    class Bus extends Vehicle {

        @Override
        int getSpeed() {
            return 0;
        }

        @Override
        int getCubicCapacity() {
            return 0;
        }

        String getEmergencyExitLock() {
            String h="";
            return h;
        }
    }

    class Main{

        public static void main(String[] args) {
            Vehicle vehicle = new Car();
            vehicle.getSpeed();

            vehicle = new Bus();
            vehicle.getCubicCapacity();
        }

    }