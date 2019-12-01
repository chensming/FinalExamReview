class Outer{
    private String name = "Hello World";

    public class Inner{
        public void print(){
            System.out.println(name);
        }
    }

    public void print(){
        new Inner().print();
    }
}

public class Note2{
    public static void main(String args[]){
        Outer outer = new Outer();
        outer.print();
    }
}