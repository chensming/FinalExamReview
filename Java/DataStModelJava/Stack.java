import java.util.LinkedList;

public class Stack {
    public static void main(String[] args) {
        myStack stack = new myStack();

        for (int i = 0; i < 10; i++)
            stack.push(i * 2);
        System.out.println("stack.top(): " + stack.top());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}


class myStack {
    private LinkedList list = new LinkedList();

    public void push(Object v) {
        list.addFirst(v);
    }

    public Object top() {
        return list.getFirst();
    }

    public Object pop() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}