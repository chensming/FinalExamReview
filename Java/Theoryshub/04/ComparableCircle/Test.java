import java.util.Scanner;

public class Test
{
    public static void main(String args[])
    {
        ComparableCircle[] circle=new ComparableCircle[2];
        Scanner sc=new Scanner(System.in);

        //input the info
        for (int i=0;i<2;i++)
        {
            double x,y,r;
            System.out.println("Input the info of the circle"+(i+1)+": ");
            System.out.print("The x coordinate of the center: ");
            x=sc.nextDouble();
            System.out.print("The y coordinate of the center: ");
            y=sc.nextDouble();
            System.out.print("The radius: ");
            r=sc.nextDouble();
            circle[i]=new ComparableCircle(x,y,r);
            System.out.println();
        }

        //compare and print the result
        int ret=circle[0].compareTo(circle[1]);
        if (ret==-1) System.out.println("The first circle is smaller than the second one.");
        else if (ret==1) System.out.println("The first circle is bigger than the second one.");
        else System.out.println("The two circles have the same square.");

        sc.close();
    }   
}