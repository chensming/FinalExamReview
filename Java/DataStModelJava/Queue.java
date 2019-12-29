import java.util.LinkedList;

public class Test{
    public static void main(String[] args) {
        myQueue queue = new myQueue();
        for(int i = 0; i < 10; i++){
            queue.Push(i * 2);
        }
        while(!queue.IsEmpty()){
            System.out.print(queue.Pop() + " ");
        }
    }
}


class myQueue{
    private LinkedList list = new LinkedList();
    public void Push(Object v){
        list.addLast(v);
    }
    public Object Pop(){
        return list.removeFirst();
    }

    public Object Front(){
        return list.getFirst();
    }

    public boolean IsEmpty(){
        return list.isEmpty();
    }
}