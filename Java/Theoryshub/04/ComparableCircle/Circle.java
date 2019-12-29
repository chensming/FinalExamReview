abstract class Circle
{
    private double centerX,centerY;
    private double radius;

    Circle()
    {
        centerX=0;
        centerY=0;
        radius=0;
    }
    Circle(double x,double y,double r)
    {
        centerX=x;
        centerY=y;
        radius=r;
    }

    public double getCenterX()
    {
        return centerX;
    }
    public double getCenterY()
    {
        return centerY;
    }
    public double getRadius()
    {
        return radius;
    }
    public double getSquare()
    {
        return Math.PI*radius*radius;
    }
}