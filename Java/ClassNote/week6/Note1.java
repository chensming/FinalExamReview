class A{
    A(){
        B obj = new B();
        obj.print();
    }
    class B{
        public void print(){
            System.out.println("print inner B");
        }
    }
}

public class Note1{
    public static void main(String args[]){
        A obj = new A();
    }
}