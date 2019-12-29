class TaskPay{
    double pay = 0;
    String name;

    public synchronized String getPay() throws InterruptedException {
        //老板没发工资，没法取出来，只能等等了
        while(this.pay == 0){
            this.wait();   //等待老板发工资(等待givePay函数notify一下)
        }
        String payment = name +  " 拿到了 " + String.valueOf(pay) + " 元的工资";
        pay = 0;
        return payment;
    }


    public synchronized void givePay(String name, double pay){
        this.name = name;
        this.pay = pay;
        this.notifyAll();//通知员工（getPay函数）可以领工资了
    }
}

//负责发工资的一类
class WorkerThread extends Thread{
    TaskPay personPay;

    public WorkerThread(TaskPay personPay){
        this.personPay = personPay;
    }


    @Override
    public void run() {
        while(!isInterrupted()){
            String operation;
            try{
                operation = personPay.getPay();
            }catch(InterruptedException e){
                System.out.println("发生异常");
//                e.printStackTrace();
                break;
            }
            String result = operation;
            System.out.println(result);
        }
    }
}





public class Pay {
    public static void main(String[] args) throws InterruptedException {
        TaskPay personPay = new TaskPay();
        WorkerThread worker = new WorkerThread(personPay);
        worker.start();


        personPay.givePay("Alice", 8520.50);
        Thread.sleep(1000);
        personPay.givePay("Bob", 8546.15);
        Thread.sleep(1000);
        personPay.givePay("Jack" , 10256.57);

        worker.interrupt();
        worker.join();
        System.out.println("发放工资的工人们下班了...");
    }
}
