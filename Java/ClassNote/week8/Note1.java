import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class Note1{
    public static void main(String args[]){
        Reader reader = null;
        try{
            reader = new FileReader("Note1.txt");
            int n;
            while((n = reader.read()) != -1){
             System.out.println((char)n);
            }
        } catch( IOException e) {
            System.out.println("read-Exception : " + e.toString());
        } finally {
            if(reader != null) {
                try{
                    reader.close();
                } catch(IOException e) {
                    System.out.println("close-Exception : " + e.toString());
                }
                
            }
        }  
    }
}