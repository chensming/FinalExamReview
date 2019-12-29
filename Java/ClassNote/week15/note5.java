import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.TreeSet;

class Students implements java.lang.Comparable {
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        Students stu = (Students) o;
        if (this.getAge() > stu.getAge()) {
            return 1;
        } else if (this.getAge() == stu.getAge()) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}


public class test {
    public static void main(String[] args) {
        TreeSet s = new TreeSet();
        Students s1 = new Students("Bob", 18);
        Students s2 = new Students("Jack", 24);
        Students s3 = new Students("xueli", 45);
        Students s4 = new Students("xiaoming", 20);

        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);

        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(s.size());
    }
}