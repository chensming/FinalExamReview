

package classFiles;//把生成的class文件放到classFiles文件夹中

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
        t1.join(); // 等待线程t1执行结束
        System.out.println("End!");
    }
}