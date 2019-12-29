import java.util.Random;

public class CardDrawing
{
    public static final String SUITS[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String NUMBERS[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static void main(String args[])
    {
        Random r = new Random();
        int suit = Math.abs(r.nextInt())%4, number = Math.abs(r.nextInt())%13;
        System.out.println("The  card  you picked is "+NUMBERS[number]+" of "+SUITS[suit]+".");
    }
}