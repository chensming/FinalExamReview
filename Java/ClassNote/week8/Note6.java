import java.io.*;

public class Note6{
    public static void main(String args[]) throws IOException{
        FileReader reader = new FileReader("Test.txt");
        LineNumberReader lnr = new LineNumberReader(reader);
        String line = null;
        lnr.setLineNumber(200);//所以第一行是201
        while((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + " : " + line );
        } 
        lnr.close();
    }
}