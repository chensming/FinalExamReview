import java.util.Random;

public class Hello5{
    public static void main(String args[]){
        Random rand = new Random();
        int month = rand.nextInt(12);
        String months[] ={"January","February","March","April","May",
        "June","July","August","September","October","November","December"};
        System.out.println(months[month]); 
    }
}