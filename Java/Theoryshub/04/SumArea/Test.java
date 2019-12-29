import java.util.Scanner;

public class Test
{
    public static double sumArea(GeometricObject[] a,int n)
    {
        double ret=0;
        for (int i=0;i<n;i++)
            ret+=a[i].getArea();
        return ret;
    }

    public static void main(String args[])
    {
        GeometricObject[] a=new GeometricObject[4];
        Scanner sc=new Scanner(System.in);

        for (int i=0;i<2;i++)
        {
            double x,y,r;
            System.out.println("Input the info of the circle "+(i+1)+":");
            System.out.print("The x coordinate of the center: ");
            x=sc.nextDouble();
            System.out.print("The y coordinate of the center: ");
            y=sc.nextDouble();
            System.out.print("The radius: ");
            r=sc.nextDouble();
            a[i]=new Circle(x,y,r);
            System.out.println();
        }

        for (int i=2;i<4;i++)
        {
            double e0,e1;
            System.out.println("Input the info of the rectangle"+(i-1)+":");
            System.out.print("The first edge: ");
            e0=sc.nextDouble();
            System.out.print("The second edge: ");
            e1=sc.nextDouble();
            a[i]=new Rectangle(e0,e1);
            System.out.println();
        }

        double ans=sumArea(a,4);
        System.out.println("The sum of the areas is: "+ans);

        sc.close();
    }
}