import java.io.*;

public class Note8{
    public static void main(String args[]) throws IOException{
        try(
            //create an output stream for file temp.dat
            DataOutputStream output = new DataOutputStream(new FileOutputStream("temp2.dat"))){
            //write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
            }
        
        try(
            //create an input stream for file temp.dat
            DataInputStream input = new DataInputStream(new FileInputStream("temp2.dat"))
        ){
            //read student test scores from the temp.dat
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}