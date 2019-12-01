//枚举类
enum Weekday{
    SUN, MON, TUE, WED, THU, FRI, SAT;
}

public class Note9{
    public static void main(String args[]){
        for(Weekday day : Weekday.values()){
            System.out.println(day.ordinal() + " " + day.name());
        }
    }
    Weekday fri = Weekday.MON;
    //以下三句代码报错了
    // System.out.println("MON.name() = " + fri.name());
    // System.out.println("MON.ordinal() = " + fri.ordinal());
    // System.out.println(Weekday.valueOf("MON").name());
}