//异常跟踪
public class Note4{
    public static void main(String args[]){
        process1();
    }

    static void process1() {
        try {
            process2();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("End of program.");
        }
    }

    static void process2(){
        process3();
    }

    static void process3(){
        Integer.parseInt(null);
    }
}