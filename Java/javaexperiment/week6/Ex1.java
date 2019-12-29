class Circle{
    private double radius;
    final double PI = 3.14159;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getPerimeter(){
        return 2 * PI * radius;
    }

    public double getArea(){
        return PI * radius * radius; 
    }

}

public class Ex1{
    public static void main(String args[]){
        Circle c = new Circle(2.5);
        System.out.println("c's perimeter " + c.getPerimeter());
        System.out.println("c's area " + c.getArea());
    }
}