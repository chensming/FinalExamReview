import java.util.Scanner;
public class Hello7{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer string = new StringBuffer(str);
        // char c1,c2;
        // int stringNum = string.length();
        // for(int i = 0; i < stringNum/2; i++){
        //     c1 = string.charAt(i);
        //     c2 = string.charAt(stringNum - i -1);
        //     string.setCharAt(i,c2);
        //     string.setCharAt(stringNum - i -1,c1);
        // }
        string.reverse();
        // for(int i = 0 ;i < stringNum; i++)
        //     System.out.print(string.charAt(i));
        System.out.println(string);
    }
}