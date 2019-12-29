import java.util.LinkedList;
import java.util.List;

public class note6 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("5");
        linkedList.add("96");
        linkedList.add("48");
        linkedList.add("966");

        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());


        //获取链表元素
        for (String str : linkedList) {
            System.out.println(str);
        }


        //从链表生成子表
        List sub = linkedList.subList(1, 3);
        System.out.println(sub);

        //添加元素
        linkedList.addFirst("-101");
        linkedList.addLast("999");
        linkedList.add(5, "Five");
        System.out.println(linkedList);


        //删除元素 ,removeFirst,removeLast
        linkedList.remove(0);
        System.out.println(linkedList);

        System.out.println("size: " + linkedList.size());
    }
}