import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
//会自行生成Outputdemo文件

public class Note5{
    public static void main(String args[]) throws IOException{
        try(OutputStream output = new FileOutputStream("Outputdemo.txt")){
            byte[] b1 = "Hello,".getBytes("UTF-8");
            output.write(b1);
            byte[] b2 = "java".getBytes("UTF-8");
            output.write(b2);
            byte[] b3 = "\nHello,".getBytes("UTF-8");
            output.write(b3);
            byte[] b4 = "world".getBytes("UTF-8");
            output.write(b4);
        }
    }
}