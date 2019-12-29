import java.awt.Color;

class Triangle extends GeometricObject
{
    //field
    private double edge0,edge1,edge2;
    private boolean isValid;

    //constrctor
    Triangle()
    {
        edge0=0;
        edge1=0;
        edge2=0;
        isValid=false;
    }
    Triangle(double e0,double e1,double e2,Color c,boolean isFilled)
    {
        super(c,isFilled);
        edge0=e0;
        edge1=e1;
        edge2=e2;
        isValid=((e0+e1>e2)&&(e0+e2>e1)&&(e1+e2>e0));
    }
    //getField
    public double getEdge0()
    {
        return edge0;
    }
    public double getEdge1()
    {
        return edge1;
    }
    public double getEdge2()
    {
        return edge2;
    }
    public double getPerimeter()
    {
        return edge0+edge1+edge2;
    }
    public double getArea()
    {
        return 1.0/4*Math.sqrt((edge0+edge1+edge2)*(edge0+edge1-edge2)*(edge0+edge2-edge1)*(edge1+edge2-edge0));
    }
    public boolean getIsValid()
    {
        return isValid;
    }
    //setField
    public void setEdge0(double e)
    {
        edge0=e;
    }
    public void setEdge1(double e)
    {
        edge1=e;
    }
    public void setEdge2(double e)
    {
        edge2=e;
    }
}