import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.TreeSet;

public class test{
    public static void main(String[] args) {
        TreeSet s = new TreeSet();

        s.add(1);
        s.add(10);
        s.add(100);
        s.add(80);
        s.add(34);

        Iterator it = s.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}