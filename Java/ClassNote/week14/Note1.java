
import java.util.*;

public class Note1{
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList();

        a1.add("stu01");
        a1.add("stu02564");
        a1.add("stu03fewf");


        Iterator<String> it = a1.iterator();
        while(it.hasNext())
        {
            String s =  it.next();
            System.out.println(s + " : " + s.length());
        }
    }
}