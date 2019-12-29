//package javaLab.exp1;
import java.awt.*;

public class WordThread extends Thread{
    char word;
    int k=19968;
    Label com;
    WordThread(Label com)
    {  this.com=com;
    }
    public void run()
    {  k=19968;
        while(true)
        {
            word=(char)k;
            com.setText(""+word);
            try{
                ////////////////////////////////////
                Thread.sleep(6000);


                //【代码1】//调用sleep方法使得线程中断6000豪秒
            }
            catch(InterruptedException e){}
            k++;
            if(k>=29968) k=19968;
        }
    }
}
