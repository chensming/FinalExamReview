class Rectangle extends GeometricObject
{
    private double edge0,edge1;

    Rectangle()
    {
        edge0=0;
        edge1=0;
    }
    Rectangle(double e0,double e1)
    {
        edge0=e0;
        edge1=e1;
    }

    public double getEdge0()
    {
        return edge0;
    }
    public double getEdge1()
    {
        return edge1;
    }
    public double getArea()
    {
        return edge0*edge1;
    }
}