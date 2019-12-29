public class TestOutOfMemoryError {
    public static void main(String[] args) {
        try {
            long[] arr = new long[1000000000];
        }
        catch (OutOfMemoryError oomErr) {
            System.out.println("Catch OutOfMemoryError!");
        }
    }
}
