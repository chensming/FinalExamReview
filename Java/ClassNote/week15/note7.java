import java.util.LinkedList;
import java.util.List;

public class Test{
    public static void main(String[] args) {

        //LinkList转为数组
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("E");
        String[] my = list.toArray(new String[0]);
        for(int i = 0; i < my.length; i++){
            System.out.println(my[i]);
        }
        
    }
}