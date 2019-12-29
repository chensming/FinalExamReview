//package javaLab.exp1;

import java.awt.*;
import java.awt.event.*;

public class ThreadFrame extends Frame implements ActionListener {
    Label  wordLabel;
    Button button;
    TextField inputText,scoreText;
    ////////////////////////////////////////////

    WordThread giveWord;
    //【代码2】//用WordThread声明一个giveWord对象
    int score=0;
    ThreadFrame()
    { wordLabel=new Label(" ",Label.CENTER);
        wordLabel.setFont(new Font("",Font.BOLD,72));
        button=new Button("开始");
        inputText=new TextField(3);
        scoreText=new TextField(5);
        scoreText.setEditable(false);
        ////////////////////////////////


        giveWord = new WordThread(wordLabel);
        //【代码3】//创建giveWord，将wordLabel传递给WordThread构造方法的参数
        button.addActionListener(this);
        inputText.addActionListener(this);
        add(button,BorderLayout.NORTH);
        add(wordLabel,BorderLayout.CENTER);
        Panel southP=new Panel();
        southP.add(new Label("输入标签所显示的汉字后回车:"));
        southP.add(inputText);
        southP.add(scoreText);
        add(southP,BorderLayout.SOUTH);
        setBounds(100,100,350,180);
        setVisible(true);
        validate();
        addWindowListener(new WindowAdapter()
                          { public void windowClosing(WindowEvent e)
                          { System.exit(0);
                          }
                          }
        );
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button)
        {  if(!(giveWord.isAlive()))    //【代码4】  giveWord调用方法isAlive()
        {    giveWord=new WordThread(wordLabel);
        }
            try
            {
                ////////////////////////////////////
                giveWord.start();


                //【代码5】//giveWord调用方法start()
            }
            catch(Exception exe){}
        }
        else if(e.getSource()==inputText)
        {  if(inputText.getText().equals(wordLabel.getText()))
        {  score++;
        }
            scoreText.setText("得分:"+score);
            inputText.setText(null);
        }
    }
}
