//“Ï≥£¥¶¿Ì

import java.util.Scanner;

class QuotientWithException{
    public static int quotient(int number1, int number2){
        if(number2 == 0)
            throw new ArithmeticException("Dvisor can't be zero!");
        return number1 / number2;
    }
}

public class Note1{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.print("enter two integers: ");
        int number1 = in.nextInt();
        int number2 = in.nextInt();

        try{
            int result = QuotientWithException.quotient(number1,number2);
            System.out.println(number1 + "/" + number2 + " is " + result);
        }catch(ArithmeticException ex){
            System.out.println("Exception: an integer " + "can't be divided by zero "); 
        }
        System.out.println("Exception continue...");
    }
}