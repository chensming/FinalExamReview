import java.util.Scanner;
import java.io.*;

public class Encrypt{
    public static void main(String args[]) throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要要进行加密的文件名(如xxx.txt)");
        String primary = in.nextLine();
        System.out.println("请输入要输出加密后的文件名(如yyy.txt)");
        String after = in.nextLine();
        Reader reader = new FileReader(primary);
        FileWriter fw = new FileWriter(after);
        int n;
        try{
            while((n = reader.read()) != -1){
                fw.write((char)(n + 3));
            }
        } catch(IOException e) {
            System.out.println("加密文件过程中出错 " + e.toString());
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch(IOException e) {
                    System.out.println("关闭来源文件过程中出错 " + e.toString());
                }
            }
            if(fw != null){
                try{
                    fw.close();
                }catch(IOException e){
                    System.out.println("关闭加密后文件过程中出错 " + e.toString());          
                }
            }
        }
    }
}