 //在这里JVM会自动关闭Reader
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class Note4{
    public static void main(String args[]){
        // Reader reader = null;
        try(Reader reader = new FileReader("Note1.txt")){
            int n;
            while((n = reader.read()) != -1){
             System.out.println((char)n);
            }
        } catch( IOException e) {
            System.out.println("read-Exception : " + e.toString());
        }    
    }
}