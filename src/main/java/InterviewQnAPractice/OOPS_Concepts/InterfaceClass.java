package InterviewQnAPractice.OOPS_Concepts;

interface IAnimal{

    String animalName = "AnimalName -> ";
    void makeSound();

}

class Animal_Dog implements  IAnimal{

    public void makeSound() {
        System.out.println("Animal sound like Dog...");
    }
}

public class InterfaceClass {

    public static void main(String[] args) {
        new Animal_Dog().makeSound();
    }

}
