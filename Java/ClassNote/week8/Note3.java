import java.io.*;

public class Note3{
    public static void main(String args[]) throws IOException{
        FileReader reader = new FileReader("Note3.txt");
        BufferedReader buffered = new BufferedReader(reader);
        String line = null;
        while((line = buffered.readLine()) != null) {
            System.out.println(line);
        }
        buffered.close();
    }
}