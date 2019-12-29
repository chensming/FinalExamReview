//import ;
import java.util.Random;

public class Test
{
    private static int[] a;

    private static void generateElements(int n)
    {
        Random r=new Random();
        a=new int[n];
        for (int i=0;i<n;i++)
            a[i]=r.nextInt();
    }
    private static void selectionSort(int[] a,int n)
    {
        for (int i=0;i<n;i++)
        {
            int minIndex=i;
            for (int j=i+1;j<n;j++)
                if (a[j]<a[minIndex]) minIndex=j;
            int temp=a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
    }
    public static void main(String args[])
    {
        StopWatch st=new StopWatch();

        generateElements(100000);
        st.start();
        selectionSort(a, 100000);
        st.stop();

        System.out.println("The time used in the selection sort is "+st.getElapsedTime()+"ms.");
    }
}