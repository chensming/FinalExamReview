//线程的创建，通过继承Thread

package classFiles;//把生成的class文件放到classFiles文件夹中

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread create");
    }
}

public class Note1{
    public static void main(String args[]){
        Thread t = new MyThread();
        t.start();
        System.out.println("main over");
    }
}

