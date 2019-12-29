class Circle extends GeometricObject
{
    double centerX,centerY,radius;

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
    public double getArea()
    {
        return Math.PI*radius*radius;
    }
}