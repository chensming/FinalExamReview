
class Car{
    private int enterYear; //进站年份
    private int enterMonth;
    private int enterDay;
    private int enterHour;
    private int enterMinute;
    private int enterSecond;
    private int exitYear; //离站年份
    private int exitMonth;
    private int exitDay;
    private int exitHour;
    private int exitMinute;
    private int exitSecond;
    private String enterStation; //进站名称
    private String exitStation; //离站名称
    private String color; //车的颜色
    private String band; //车的牌子
    private String size; //车子大小，如七座一下轿车，大货车，大客车等

    //进站信息函数
    public int getEnterYear(){
        return enterYear;
    }

    public int getEnterMonth(){
        return enterMonth;
    }

    public int getEnterDay(){
        return enterDay;
    }

    public int getEnterHour(){
        return enterHour;
    }

    public int getEnterMinute(){
        return enterMinute;
    }

    public int getEnterSecond(){
        return enterSecond;
    }

    public void setEnterYear(int year){
        this.enterYear = year;
    }

    public void setEnterMonth(int month){
        this.enterMonth = month;
    }

    public void setEnterDay(int day){
        this.enterDay = day;
    }

    public void setEnterHour(int hour){
        this.enterHour = hour;
    }

    public void setEnterMinute(int minute){
        this.enterMinute = minute;
    }

    public void setEnterSecond(int second){
        this.enterSecond = second;
    }

    //离站信息函数
    public int getExitYear(){
        return exitYear;
    }
    
    public int getExitMonth(){
        return exitMonth;
    }
    
    public int getExitDay(){
        return exitDay;
    }
    
    public int getexitHour(){
        return exitHour;
    }
    
    public int getExitMinute(){
        return exitMinute;
    }
    
    public int getExitSecond(){
        return exitSecond;
    }
    
    public void setExitYear(int exitYear){
        this.exitYear = exitYear;
    }
    
    public void setExitMonth(int exitMonth){
        this.exitMonth = exitMonth; 
    }    
    
    public void setExitDay(int exitDay){
        this.exitDay = exitDay;
    }
    
    public void setExitHour(int exitHour){
        this.exitHour = exitHour;
    } 

    public void setExitMinute(int exitMinute){
        this.exitMinute = exitMinute;
    }

    public void setExitSecond(int exitSecond){
        this.exitSecond = exitSecond;
    }
    
    
    //车子进站出站
    public String getStation(){
        return enterStation;
    }

    public String exitStation(){
        return exitStation;
    }

    public void setEnterStation(String enterStation){
        this.enterStation = enterStation;
    }

    public void setExitStation(String exitStation){
        this.exitStation = exitStation;
    }


    //车子颜色color，大小size，牌子band
    public String getColor(){
        return color;
    }

    public String getSize(){
        return size;
    }

    public String getBand(){
        return band;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setSize(String size){
        this.size = size;
    }

    public void setBand(String band){
        this.band = band;
    }

}


public class J_Car{
    public static void main(String args[]){
        Car car1 = new Car();
    }
}