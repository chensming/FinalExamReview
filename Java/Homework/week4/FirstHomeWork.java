class Circle{
    private double radius;
    private double area;
    final double PI = 3.1415926;

    public Circle(double radius){
        this.radius = radius;
        this.area = PI * radius * radius; 
    }

    public double getRadius(){  
        return radius;
    }

    public double getArea(){
        return area;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

}

interface Comparable{
    ComparableCircle ComparableTo(ComparableCircle c2);
}

class ComparableCircle extends Circle implements Comparable{
    ComparableCircle(double radius){
        super(radius);
    }    

    public ComparableCircle ComparableTo(ComparableCircle c2){
        return getArea()>c2.getArea()?this:c2;
    }
}

public class FirstHomeWork{
    public static void main(String args[]){
        ComparableCircle c1 = new ComparableCircle(9.5);
        ComparableCircle c2 = new ComparableCircle(6.5);
        ComparableCircle c3 = (ComparableCircle)c1.ComparableTo(c2);
        System.out.println("c3's radius: " + ((Circle)c3).getRadius());
        System.out.println("c3's area: " + ((Circle)c3).getArea());
        
    }
}   