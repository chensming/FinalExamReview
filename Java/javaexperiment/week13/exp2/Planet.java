//package javalabexp.exp2;

import java.awt.*;


public class Planet extends Panel implements Runnable {
    ////////////////////////
    Thread moon;

    // 【代码1】   用Thread类声明一个moon对象
    Mycanvas yellowBall;
    double pointX[] = new double[360],
            pointY[] = new double[360]; //用来表示画布左上角端点坐标的数组
    int w = 100, h = 100;
    int radius = 30;

    Planet() {
        setSize(w, h);
        setLayout(null);
        yellowBall = new Mycanvas();
        yellowBall.setColor(Color.yellow);
        add(yellowBall);
        yellowBall.setSize(12, 12);
        yellowBall.setR(12 / 2);
        pointX[0] = 0;
        pointY[0] = -radius;
        double angle = 1 * Math.PI / 180;   //刻度为1度
        for (int i = 0; i < 359; i++)        //计算出数组中各个元素的值
        {
            pointX[i + 1] = pointX[i] * Math.cos(angle) - Math.sin(angle) * pointY[i];
            pointY[i + 1] = pointY[i] * Math.cos(angle) + pointX[i] * Math.sin(angle);
        }
        for (int i = 0; i < 360; i++) {
            pointX[i] = pointX[i] + w / 2;    //坐标平移
            pointY[i] = pointY[i] + h / 2;
        }
        yellowBall.setLocation((int) pointX[0] - yellowBall.getR(),
                (int) pointY[0] - yellowBall.getR());
        /////////////////////////////////
        moon = new Thread(this);


        //【代码2】 创建 moon线程，当前面板做为该线程的目标对象
    }

    public void start() {
        try {
            moon.start();
        } catch (Exception exe) {
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(w / 2 - 9, h / 2 - 9, 18, 18);
    }

    public void run() {
        int i = 0;
        while (true) {
            i = (i + 1) % 360;
            yellowBall.setLocation((int) pointX[i] - yellowBall.getR(),
                    (int) pointY[i] - yellowBall.getR());
            try {
                /////////////////////////////////////////
                Thread.sleep(10);

                //【代码3】  Thread类调用类方法sleep使得线程中断10豪秒
            } catch (InterruptedException e) {
            }
        }
    }
}
