import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EncodingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFileName;
        String outputFileName;
        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;

        try {
            //description
            System.out.println("This program is used to encode a text file in UTF-8 and write it to a binary file.");
            System.out.println();

            //input input file name
            System.out.print("Please input the input file name: ");
            inputFileName = scanner.nextLine();
            inputFile = new FileInputStream(inputFileName);
            System.out.println();

            //read
            byte[] ba = new byte[(int)(new File(inputFileName)).length()];
            inputFile.read(ba);
            String string = new String(ba);

            //input output file name
            System.out.print("Please input the output file name: ");
            outputFileName = scanner.nextLine();
            outputFile = new FileOutputStream(outputFileName);
            System.out.println();

            //write
            outputFile.write(string.getBytes(StandardCharsets.UTF_8));

            //prompt
            System.out.println("THe length of " + inputFileName + ": " + (new File(inputFileName)).length() + " bytes.");
            System.out.println("THe length of " + outputFileName + ": " + (new File(outputFileName)).length() + " bytes.");
            System.out.println("Finished!");
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
