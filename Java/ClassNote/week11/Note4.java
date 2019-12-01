

package classFiles;//把生成的class文件放到classFiles文件夹中

public class Note4{
    public static void main(String args[]){
        Thread curr;
        int num = 7;
        curr = Thread.currentThread();
        curr.setPriority(num);
        System.out.println("1.当前线程: " + curr);
        System.out.println("2.线程名: " + curr.getName());
        System.out.println("3.优先级: " + curr.getPriority());
    }
}