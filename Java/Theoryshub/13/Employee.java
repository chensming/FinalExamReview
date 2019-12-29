class Account {
    public double salary;
    public boolean Is_Ready;
    public int ID;

    public Account(int n) {
        ID = n;
    }

    public synchronized void receive() {
        salary = (Math.random() * 100000);
        System.out.println("ID:" + ID + "的员工收到工资" + salary + "元");
        Is_Ready = true;
        notify();
    }

    public synchronized void takeSalary() {
        if (Is_Ready == false) {
            System.out.println("ID:" + ID + "的员工请等待发放工资");
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e);
            }
        }
        System.out.println("ID:" + ID + "的员工提取工资" + salary + "元");
        salary = 0;
        Is_Ready = false;
    }
}

class Company extends Thread {
    Account account[] = new Account[1000];
    public int number;

    public Company() {
        number = 0;
    }

    public void getAccount(Account a) {
        account[number++] = a;
    }

    public void run() {
        for (int i = 0; i < number; i++)
            account[i].receive();
    }
}

public class Employee extends Thread {
    Account account;
    public int ID;

    public Employee(Account a) {
        account = a;
    }

    public void run() {
        account.takeSalary();
    }

    public static void main(String args[]) {
        Company c = new Company();
        Account a1 = new Account(1);
        c.getAccount(a1);
        Account a2 = new Account(2);
        c.getAccount(a2);
        Employee e1 = new Employee(a1);
        Employee e2 = new Employee(a2);
        e1.start();
        e2.start();
        c.start();
    }
}