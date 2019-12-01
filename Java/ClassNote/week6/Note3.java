class A{
    A(){
        (new B(){
            public void print(){
                System.out.println("How about your national day");
            }
        }).print();
    }
}

class B{
    //作为A的内部类
}

public class Note3{
    public static void main(String args[]){
        A obj = new A();
    }
}