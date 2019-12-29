import java.awt.Color;

abstract class GeometricObject
{
    //field
    private Color color;
    private boolean isFilled;

    //constructor
    GeometricObject()
    {
        color=Color.black;
        isFilled=false;
    }
    GeometricObject(Color color,boolean isFilled)
    {
        this.color=color;
        this.isFilled=isFilled;
    }
    //getField
    public boolean getIsFilled()
    {
        return isFilled;
    }
    public Color getColor()
    {
        return color;
    }
    abstract public double getPerimeter();
    abstract public double getArea();
    //setField
    public void setIsFilled(boolean isFilled)
    {
        this.isFilled=isFilled;
    }
    public void setColor(Color color)
    {
        this.color=color;
    }
}