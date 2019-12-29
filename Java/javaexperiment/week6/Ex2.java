class Student{
    private String sNo;
    private String sName;
    private char sSex;
    private int sAge;
    private float sJava;

    Student(String sNo, String sName, char sSex, int sAge, float sJava){
        this.sNo = sNo;
        this.sName = sName;
        this.sSex = sSex;
        this.sAge = sAge;
        this.sJava = sJava;
    }

    public String getNo() {
        return sNo;
    }

    public String getName(){
        return sName;
    }

    public char getSex(){
        return sSex;
    }

    public int getAge(){
        return sAge;
    }

    public float getJava(){
        return sJava;
    }
}

public class Ex2{
    public static void main(String args[]){
        Student s = new Student("20191010","Wang Lin",'女',22,100);
        System.out.println("学号: " + s.getNo());
        System.out.println("姓名: " + s.getName());
        System.out.println("性别: " + s.getSex());
        System.out.println("年龄: " + s.getAge());
        System.out.println("java成绩: " + s.getJava());          
    }
}