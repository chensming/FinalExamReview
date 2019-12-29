import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class TestArrayIndexOutBoundException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] a = new int[100];

        for (int i = 0; i < 100; i++)
            a[i] = r.nextInt();

        try {
            while (true) {
                System.out.println("Input an integer(0~99) and I will show you the value at this index:");
                int index = sc.nextInt();
                System.out.println("The value at index " + index + " is " + a[index] + ".");
                System.out.println();
            }
        }
        catch (ArrayIndexOutOfBoundsException aioobExp) {
            System.out.println("OutofBounds!");
        }
        catch (InputMismatchException imExp) {
            System.out.println("The input is not an integer!");
        }
        finally {
            sc.close();
        }
    }
}
