import java.io.*;


public class Utftobinary{
    public static void main(String args[]) throws IOException{
        Reader reader = null;
        DataOutputStream output = new DataOutputStream(new FileOutputStream("d.txt")); 
        try {
            reader = new FileReader("c.txt");
            char[] buffer = new char[1024];
            int len = 0;
            while((len = reader.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                output.writeUTF(str);
            }
            File dir1 = new File("c.txt");
            File dir2 = new File("d.txt");
            System.out.println("c.txt 's Size: " + dir1.length());
            System.out.println("d.txt 's Size: " + dir2.length());
        }catch(IOException e){
            System.out.println("reader-exception: " + e.toString());
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                    System.out.println("close-Exception :" + e.toString());
                }
            }
            if(output != null){
                try{
                    output.close();
                }catch(IOException e){
                    System.out.println("close-Exception :" + e.toString());
                }
            }
            
        }
        
        
    }
}