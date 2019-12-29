class ComparableCircle extends Circle implements Comparable<ComparableCircle>
{
    ComparableCircle()
    {
        super();
    }
    ComparableCircle(double x,double y,double r)
    {
        super(x,y,r);
    }


    public int compareTo(ComparableCircle c)
    {
        double s0=this.getSquare(),s1=c.getSquare();
        //System.err.println(s0);
        //System.err.println(s1);
        if (Math.abs(s0-s1)<1e-10) return 0;
        else if (s0<s1) return -1;
        else return 1;
    }
}