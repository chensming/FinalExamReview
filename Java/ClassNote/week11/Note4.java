

package classFiles;//�����ɵ�class�ļ��ŵ�classFiles�ļ�����

public class Note4{
    public static void main(String args[]){
        Thread curr;
        int num = 7;
        curr = Thread.currentThread();
        curr.setPriority(num);
        System.out.println("1.��ǰ�߳�: " + curr);
        System.out.println("2.�߳���: " + curr.getName());
        System.out.println("3.���ȼ�: " + curr.getPriority());
    }
}