

package classFiles;//�����ɵ�class�ļ��ŵ�classFiles�ļ�����

class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread 1!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Note5{
    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new MyThread();
        System.out.println("start...");
        t1.start();
        t1.join(); // �ȴ��߳�t1ִ�н���
        System.out.println("End!");
    }
}