//�̵߳�˳��

package classFiles;//�����ɵ�class�ļ��ŵ�classFiles�ļ�����


public class Note3{
    public static void main(String args[]){
        System.out.println("main start");
        Thread t = new Thread(){
            public void run(){
                System.out.println("Thread...run");
                System.out.println("Thread end");
            }
        };
        t.start();
        System.out.println("main end");
    }
}