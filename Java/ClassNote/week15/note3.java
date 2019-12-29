import jdk.nashorn.internal.ir.CatchNode;

import java.util.HashSet;
import java.util.Iterator;

class Cat {
    public static String name;
    public static int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class test {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("abc");
        hashSet.add(1);
        hashSet.add('a');
        int[] abcd = {10, 11, 12};
        hashSet.add(abcd);

        /*
        hashSet.remove(abcd)
        if(!hashSet.add(abcd)){
            System.out.println("false");
        }
        */
        Cat c1 = new Cat("pitty", 3);
        hashSet.add(c1);


        System.out.println("size: " + hashSet.size());



        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Integer) {
                System.out.println("Integer: " + obj);
            } else if (obj instanceof String) {
                System.out.println("String: " + obj);
            } else if (obj instanceof Character) {
                System.out.println("Character: " + obj);
            } else if (obj instanceof int[]) {
                System.out.println("int[]: " + obj);
                for (int i : abcd) {
                    System.out.print(i + " ");
                }
            }
        }

        System.out.println();
        hashSet.clear();
        System.out.println("after clearing size: " + hashSet.size());
    }
}