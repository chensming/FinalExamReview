//线程的创建，通过Runable接口


package  classFiles;

class MyThread implements Runnable{
    public void run(){
        System.out.println("Thread create");
    }
}

public class Note2{
    public static void main(String args[]){
        Runnable r = new MyThread();
        Thread t = new Thread(r);
        t.start();
        System.out.println("main over");
    }
}

