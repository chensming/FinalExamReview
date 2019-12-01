

package classFiles;//把生成的class文件放到classFiles文件夹中

class MyThread extends Thread{
    public void run(){
        while(!isInterrupted()){
            System.out.println("Thread running!");
        }
    }
}


public class Note6{
    public static void main(String args[]) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}