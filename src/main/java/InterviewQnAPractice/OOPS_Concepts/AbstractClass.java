package InterviewQnAPractice.OOPS_Concepts;

abstract class HighEndCar{

    abstract public void startEngine();

    void applyBreak(){
        System.out.println("Apply break in a car is common. so it is already implemented and no need to reinvent the wheel.");
    }

    void makeSound(){
        System.out.println("This is implemented in Asbstract class itself.");
    }

}

class Car_Benz_Method_OverRide extends HighEndCar{

    public void startEngine() {
        System.out.println("Start engine for car -> Benz");
    }

    public void makeSound() {
        super.makeSound();
        System.out.println("This is additional work done for benz car only.");
    }

}

class Car_Audi_without_Method_OverRide extends HighEndCar{

    @Override
    public void startEngine() {
        System.out.println("Start engine for car -> Audi");
    }

    public void makeSound() {
        super.makeSound();
        System.out.println("This is additional work done for Audi car only.");
    }

}


public class AbstractClass {

    public static void main(String[] args) {

        new Car_Benz_Method_OverRide().applyBreak();
        new Car_Benz_Method_OverRide().makeSound();
        new Car_Benz_Method_OverRide().startEngine();
        System.out.println("-----------------------");

        new Car_Audi_without_Method_OverRide().makeSound();
        new Car_Audi_without_Method_OverRide().startEngine();

    }

}
