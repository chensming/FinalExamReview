import java.util.Scanner;
import java.awt.Color;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Triangle t;
        double e0,e1,e2;
        int r,g,b;
        Color c;
        String str;
        boolean isFilled;

        System.out.println("Please input the color:");
        System.out.println("Please input the R value(0~255):");
        r=sc.nextInt();
        System.out.println("Please input the G value(0~255):");
        g=sc.nextInt();
        System.out.println("Please input the B value(0~255):");
        b=sc.nextInt();
        c=new Color(r,g,b);
        sc.nextLine();
        System.out.println("Please input to set whether the triangle will be filled(Y/N):");
        str=sc.nextLine();
        if (str.equals("Y")) isFilled=true;
        else isFilled=false;
        System.out.println();

        while (true)
        {
            System.out.println("Please input edge 0:");
            e0=sc.nextDouble();
            System.out.println("Please input edge 1:");
            e1=sc.nextDouble();
            System.out.println("Please input edge 2:");
            e2=sc.nextDouble();
            t=new Triangle(e0,e1,e2,c,isFilled);
            System.out.println();
            if (!(t.getIsValid()))
            {
                System.out.println("Invalid triangle, please input again!");
                System.out.println();
            }
            else break;
        }

        System.out.println("Perimeter: "+t.getPerimeter());
        System.out.println("Area: "+t.getArea());
        System.out.println("Color: "+t.getColor());
        System.out.print("Is it filled: ");
        if (t.getIsFilled()) System.out.println("Yes");
        else System.out.println("No");
    }
}