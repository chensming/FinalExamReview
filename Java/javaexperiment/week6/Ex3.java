class Vehicle{
    //负数代表反方向
    private double speed;
    private double size;

    public void move(){
        speed = 1.0;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setSize(double size){
        this.size = size;
    }

    public double getSpeed(){
        return speed;
    }

    public double getSize(){
        return size;
    }

    public void speedUp(double up){
        speed = speed + up;
    }

    public void speedDown(double down){
        speed = speed - down;
    }

}

public class Ex3{
    public static void main(String args[]){
        Vehicle v = new Vehicle();
        v.setSpeed(10);
        v.setSize(50);
        System.out.println("v's speed: " + v.getSpeed());
        System.out.println("v's size: " + v.getSize());
        v.speedUp(5);
        System.out.println("v speedUP ... speed+5");
        System.out.println("v's speed: " + v.getSpeed());
        v.speedDown(2);
        System.out.println("v speedDown ... speed-2");
        System.out.println("v's speed: " + v.getSpeed());
    }
}