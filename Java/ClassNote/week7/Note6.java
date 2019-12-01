//catch中有多个异常写在一起

public class Note6{
    public static void main(String args[]){
        process("0");
    }

    static void process(String s){
        try {
            int n = Integer.parseInt(s);
            int m = 100 / n;
        } catch (NumberFormatException | ArithmeticException e){
            System.out.println(e);
            System.out.println("Bad input.");
        }finally{
            System.out.println("End of program.");
        }
    }
}