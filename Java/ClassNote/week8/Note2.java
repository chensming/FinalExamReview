import java.io.FileWriter;
import java.io.IOException;

public class Note2{
    public static void main(String args[]){
        FileWriter fw = null;
        try{
            fw = new FileWriter("Test.txt");
            fw.write("This is the first time with you in library to study together on 2019.10.27");
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            if(fw != null) {
                try{
                    fw.close();
                } catch (IOException e){
                    System.out.println(e.toString());
                }
            }
        }
    }
}