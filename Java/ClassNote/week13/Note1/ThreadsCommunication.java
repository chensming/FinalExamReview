
class shareClass{
    private int n;
    private boolean flag = false;


    void produce(int i){
        while(flag){

        }
        n = i;
        flag = true;
        System.out.println("产生数据: " + n);
    }

    void get(){
        while(!flag){}
        flag = false;
        System.out.println("读取数据: " + n);

    }
}

class Producer implements Runnable{
    shareClass shc; //声明
    Producer(shareClass c){
        shc = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            shc.produce((int)(Math.random()*100));
        }
    }
}

class Consumer implements Runnable{
    shareClass shc;  //声明
    Consumer(shareClass c){
        shc = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            shc.get();
    }
}


public class ThreadsCommunication{
    public static void main(String[] args) {
        shareClass shc = new shareClass();
        Thread t1 = new Thread(new Producer(shc));
        Thread t2 = new Thread(new Consumer(shc));
        t1.start();
        t2.start();
    }
}