/*

Encapsulation
The meaning of Encapsulation, is to make sure that "sensitive"
 data is hidden from users. To achieve this, you must:

declare class variables/attributes as private
provide public get and set methods to access and
update the value of a private variable

 */
package InterviewQnAPractice.OOPS_Concepts;

public class Encapsulation {

    public static void main(String[] args) {

        //create an objet of Person

        Person p = new Person();
        p.setName("New name set to a private variable through setter");
        System.out.println(p.getName());

    }
}

class Person
{
    private String name = "Person's name";

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}