package InterviewQnAPractice.OOPS_Concepts;

public class Inheritance_and_Polymorphism {

    public static void main(String[] args) {

        Animal a = new Animal();
        a.animalSound();

        //create an object of Dog
        Dog d = new Dog();
        d.animalSound();

        Pig p = new Pig();
        p.animalSound();
    }
}


  class Animal {

     protected void animalSound() {

         System.out.println("The animal must make a sound");
     }
 }


class Dog extends  Animal
{
    Dog(){
        super.animalSound();
    }


    public  void animalSound(){
        System.out.println("The Dog only barks");
    }
}

class Pig extends  Animal
{
    public void animalSound(){
        System.out.println("The pig says wee wee");
    }
}

