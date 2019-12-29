import java.util.Random;
import java.util.Arrays;

public class Hello4{
    public static void main(String args[]){
        Random rand = new Random();
        int number[] = new int[20];
        int temp = 0;
        for(int i = 0; i < 20; i++){
            number[i] = rand.nextInt();
        }
        // for(int i = 0; i < number.length; i++)
        //     for(int j = i + 1; j < number.length; j++)   
        //         if(number[i] > number[j]){
        //             temp = number[j];
        //             number[j] = number[i];
        //             number[i] = temp;
        //         }
        Arrays.sort(number);

        for(int i = 0; i <= 19; i++) 
        {
            System.out.print(number[i] + " ");
            if(i % 5 == 0 && i != 0)
                System.out.println();
        }    
    }
}