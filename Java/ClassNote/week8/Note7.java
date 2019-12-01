import java.io.*;

public class Note7{
    public static void main(String args[]) throws IOException{
        try(
            // Create an output stream to the file 
            FileOutputStream output = new FileOutputStream("temp.dat")
        ) {
            //output value to the file
            for(int i = 1; i <= 10; i++)
                output.write(i);
        }

        try(
            //Create an input stream for the file
            FileInputStream input = new FileInputStream("temp.dat")
        ) {
            //read values from the file
            int value;
            while((value = input.read()) != -1  )
                System.out.print(value + " ");
        }
    }
}