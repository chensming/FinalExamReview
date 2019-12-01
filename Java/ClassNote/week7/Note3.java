//异常处理

import java.io.UnsupportedEncodingException;

public class Note3{
    public static void main(String args[]){
        try{
            // test("ABC"); 
            test("utf-8");
            test("ABC");
        }catch(UnsupportedEncodingException e){
            System.out.println("failed");
            System.out.println(e);
        }
    }

    static void test(String encoding) throws UnsupportedEncodingException{
        System.out.println("test encoding " + encoding + "...");
        "test".getBytes(encoding);
        System.out.println("ok.");
    }
}