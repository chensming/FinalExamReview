import java.io.*;
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFileName;
        String outputFileName;
        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;

        try {
            System.out.println("This program is used to encrypt a file by Caesar Cipher.");
            System.out.println();

            //input input file name
            System.out.print("Please input the input file name: ");
            inputFileName = scanner.nextLine();
            inputFile = new FileInputStream(inputFileName);
            System.out.println();

            //encryption
            byte[] ba = new byte[(int)(new File(inputFileName)).length()];
            inputFile.read(ba);
            for (int i=0; i < ba.length; i++)
                ba[i] += 3;

            //input output file name
            System.out.print("Please input the output file name: ");
            outputFileName = scanner.nextLine();
            outputFile = new FileOutputStream(outputFileName);
            System.out.println();
            outputFile.write(ba);

            System.out.println("Encryption finished!");
        } catch (OutOfMemoryError | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
                if (inputFile != null) {
                    inputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
