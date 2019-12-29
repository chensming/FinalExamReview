public class OutOfMemory{
    public static void main(String args[]){
        try{
            int len = Integer.MAX_VALUE;
            //开一个很大的数组，会导致OutOfMemoryError错误
            int[] a = new int[len];
        } catch (OutOfMemoryError e){
            System.out.println("The program has an OutOfMemoryError!");
        } 
    }
}