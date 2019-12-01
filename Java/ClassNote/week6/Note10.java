//int,Integer和String的转换

public class Note10{
    public static void main(String args[]){
        int i = 1000;
        //int转为Interger
        Integer num1 = new Integer(i);
        Integer num2 = Integer.valueOf(i);
        Integer num3 = Integer.valueOf("100");
        //Interger转为int
        int c1 = num1.intValue();
        int c2 = Integer.parseInt("200");
        //Interger转为String
        String str1 = num1.toString();
    }
}