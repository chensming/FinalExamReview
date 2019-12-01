import java.io.IOException;
import java.io.RandomAccessFile;

public class Note9{
    public static void main(String args[]){
        try{
            RandomAccessFile f = new RandomAccessFile("randomtext.txt","rw");
            double d;
            for(int i = 0; i < 10; i++)
                f.writeDouble(0.5 * i);
            f.seek(16);
            f.writeDouble(0);
            f.seek(0);
            for(int i = 0; i < 10; i++ ){
                d = f.readDouble();
                System.out.println("[ " + i + " ]: " + d);
            }
            f.close();
        } catch(IOException e) {
            System.err.println("¶ÁÐ´Òì³£ " + e.toString());
            // e.printStackTrack();
        }
    }
}