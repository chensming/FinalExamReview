import java.util.Scanner;

public class Hello6{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        for(int i = 0 ;i < string.length(); i++){
            if(i%2 == 1)
                continue;
            System.out.print(string.charAt(i));
        }
            
    }
}