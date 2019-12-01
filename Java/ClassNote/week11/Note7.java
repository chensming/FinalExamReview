

package classFiles;//把生成的class文件放到classFiles文件夹中


class MyThread extends Thread {
    volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("MyThread is running!");
        }
    }
}

public class Note7 {
    public static void main(String[] args) throws InterruptedException {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(1000);
            t.running = false;
            System.out.println("Main end");
    }
}

