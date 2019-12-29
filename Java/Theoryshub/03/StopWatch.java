public class StopWatch
{
    private long startTime,endTime;

    public StopWatch()
    {
        startTime=0;
        endTime=0;
    }

    public StopWatch(long st,long et)
    {
        startTime=st;
        endTime=et;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public long getElapsedTime()
    {
        return endTime-startTime;
    }

    public void start()
    {
        startTime=System.currentTimeMillis();
    }
    
    public void stop()
    {
        endTime=System.currentTimeMillis();
    }
}