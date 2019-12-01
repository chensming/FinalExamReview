class Person{
    public String name;
    public int age;
    public static int number;
}

public class Note4{
    public static void main(String args[]){
        Person alice = new Person();
        Person bob = new Person();

        alice.number = 55;
        System.out.println(bob.number);

        Person.number = 66;
        System.out.println(Person.number);
    }
}