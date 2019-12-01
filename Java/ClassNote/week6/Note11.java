public class Note11{
    public static void main(String args[]){
        Integer i = 20 + Integer.valueOf(100);
        Number j = i;
        System.out.println(j.intValue());//120
        System.out.println(j.floatValue());//120.0
        System.out.println(j.doubleValue());//120.0
    }
}