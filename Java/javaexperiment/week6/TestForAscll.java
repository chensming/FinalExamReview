public class TestForAscll{
    public static void main(String args[]){
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(str1 + " :");
        for(int i = 0; i < str1.length(); i++)
            System.out.print((int)str1.charAt(i) + " ");
        System.out.println();
        System.out.println(str2 + " :");
        for(int i = 0; i < str2.length(); i++)
            System.out.print((int)str2.charAt(i) + " ");

    }
}