//static·½·¨
class Person{
    private String name;
    public int age;
    public static int number = 20;
    public static void setNumber(int num){
        number = num;
    }
    public static int getNumber(){
        return number;
    }
}
public class Note5{
    public static void main(String args[]){
        System.out.println(Person.getNumber());
        Person.setNumber(1000);
        System.out.println(Person.getNumber());
    }
}