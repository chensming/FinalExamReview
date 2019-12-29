//package javalabexp.exp2;

import java.awt.*;
import java.awt.event.*;

public class HaveThreadFrame extends Frame implements Runnable {
    ////////////////////////////////
    Thread rotate;


    //【代码4】     用Thread类声明一个rotate对象
    Planet earth;
    double pointX[] = new double[360],
            pointY[] = new double[360];
    int width, height;
    int radius = 120;

    HaveThreadFrame() {
        rotate = new Thread(this);
        earth = new Planet();
        setBounds(0, 0, 360, 400);
        width = getBounds().width;
        height = getBounds().height;
        pointX[0] = 0;
        pointY[0] = -radius;
        double angle = 1 * Math.PI / 180;
        for (int i = 0; i < 359; i++) {
            pointX[i + 1] = pointX[i] * Math.cos(angle) - Math.sin(angle) * pointY[i];
            pointY[i + 1] = pointY[i] * Math.cos(angle) + pointX[i] * Math.sin(angle);
        }
        for (int i = 0; i < 360; i++) {
            pointX[i] = pointX[i] + width / 2;
            pointY[i] = pointY[i] + height / 2;
        }
        setLayout(null);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  System.exit(0);
                              }
                          }
        );
        add(earth);
        earth.setLocation((int) pointX[0] - earth.getSize().width / 2,
                (int) pointY[0] - earth.getSize().height / 2);
        earth.start();
        /////////////////////////////

        rotate.start();
        //【代码5】     用rotate调用start方法
    }

    public void run() {
        int i = 0;
        while (true) {
            i = (i + 1) % 360;
            earth.setLocation((int) pointX[i] - earth.getSize().width / 2,
                    (int) pointY[i] - earth.getSize().height / 2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(width / 2 - 15, height / 2 - 15, 30, 30);
    }
}