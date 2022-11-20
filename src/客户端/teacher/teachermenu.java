package 客户端.teacher;

import 客户端.student.BackgroundPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class teachermenu implements ActionListener {
    Socket socket = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    private JPanel p3;

    public teachermenu() {
      //  Mysocket m = new Mysocket();
     //   this.socket = m.socket;
     //   this.br = m.getBr();
     //   this.bw = m.getBw();
        JFrame app = new JFrame("主界面");
        Container c = app.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        c.add(p1, "West");
        p1.setLayout(new GridLayout());
        JPanel p2 = new teapanel(this);
        p1.add(p2);
        Image icon = new ImageIcon("src\\background\\002.png").getImage();
        p3 = new BackgroundPanel(icon);
        JScrollPane spane = new JScrollPane(p3);
        c.add(spane, "Center");
        Image icon2 = new ImageIcon("src\\background\\004.jpg").getImage();
        JPanel p5 = new 客户端.student.BackgroundPanel(icon2);
        c.add(p5, "South");

        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p6.setBackground(Color.yellow);
        c.add(p6, "North");
        app.setSize(1000, 600);
        app.setLocation(200, 80);
        app.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hell");
        p3.setLayout(new FlowLayout());
        if (e.getActionCommand() == "审核学分") {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new shenhe());
            p3.setVisible(true);
        }else if(e.getActionCommand() == "查看学分明细") {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new chakan());
            p3.setVisible(true);
        }else if(e.getActionCommand() == "回复留言") {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new huifu());
            p3.setVisible(true);
        }else if(e.getActionCommand() == "修改信息") {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new xiugaixinxi());
            p3.setVisible(true);
        } else if (e.getActionCommand() == "退出") {
            System.exit(0);
        }else if(e.getActionCommand() == "沟通") {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new Client_c());
         //   new Client_c();
            p3.setVisible(true);
        }
    }
}

