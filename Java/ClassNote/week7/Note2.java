//异常处理

import java.io.UnsupportedEncodingException;
public class Note2{
    public static void main(String args[]){
        test("UTF-8");
        test("ABC");
    }

    static void test(String encoding){
        System.out.println("test coding " + encoding + "...");
        try {
            "test".getBytes(encoding);
            System.out.println("ok");
        }catch(UnsupportedEncodingException e){
            System.out.println("failed.");
            System.out.println(e);
        }
    }
}