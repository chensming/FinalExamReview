//wait 和 notify

import java.util.LinkedList;
import java.util.Queue;


class TaskQueue{
    final Queue<String> queue = new LinkedList<>();
    public synchronized String getTask() throws InterruptedException{
        while(this.queue.isEmpty()){
            this.wait();
        }
        return queue.remove();
    }

    public synchronized void addTask(String name){
        this.queue.add(name);
        //通知线程池中的线程可以执行了
        this.notifyAll();
    }
}

class WorkerThread extends Thread{
    TaskQueue taskQueue;

    public WorkerThread(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            String name;
            try{
                name = taskQueue.getTask();
            }catch (InterruptedException e){
                break;
            }
            String result = name;
            System.out.println(result);
        }
    }
}



public class Notify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        WorkerThread worker = new WorkerThread(taskQueue);
        worker.start();

        taskQueue.addTask("Alice");
        Thread.sleep(1000);
        taskQueue.addTask("Bob");
        Thread.sleep(1000);
        taskQueue.addTask("Jack");
        Thread.sleep(1000);

        worker.interrupt();
        worker.join();
        System.out.println("end of program");
    }
}
