import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Student{
    String name;
    double age;

    Student(String name,double age)
    {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }
}



public class test {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Alice");
        set.add("Bob");
        set.add("Jack");
        Iterator it = set.iterator();
        while(it.hasNext()){
           Object obj = it.next();
           System.out.println(obj);
        }
    }
}
