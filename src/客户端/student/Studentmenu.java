package 客户端.student;


import 客户端.Mysocket;
import 客户端.teacher.Client_c;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class Studentmenu implements ActionListener {
    Socket socket = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    private JPanel p3;
    static String account=null;

    public static void setAccount(String account) {
        Studentmenu.account = account;
    }

    public static String getAccount() {
        return account;
    }

    public Studentmenu() {
        Mysocket m = new Mysocket();
        this.socket = m.socket;
        this.br = m.getBr();
        this.bw = m.getBw();
        JFrame app = new JFrame("主界面");
        Container c = app.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        c.add(p1, "West");
        p1.setLayout(new GridLayout());
        JPanel p2 = new Stupanel(this).jp();
        p1.add(p2);
        Image icon = new ImageIcon("src\\background\\001.jpg").getImage();
        p3 = new 客户端.student.BackgroundPanel(icon);
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
        p3.setLayout(new FlowLayout());
        if (e.getActionCommand() == "申请学分") {

            Mysocket ms=new Mysocket();
            ms.sendm(ms,"申请学分");

            //   System.out.println("申请学分");

            p3.setVisible(false);
            p3.removeAll();
            p3.add(new shenqing());
            p3.setVisible(true);
        }else if(e.getActionCommand() == "留言") {
            Mysocket ms=new Mysocket();
            ms.sendm(ms,"留言");
          //  System.out.println("hello");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new liuyan());
            p3.setVisible(true);
        }else if(e.getActionCommand() == "沟通") {
            Mysocket ms=new Mysocket();
            ms.sendm(ms,"沟通");

            p3.setVisible(false);
            p3.removeAll();
            p3.add(new Client_c());
        //    new Client_c();
            p3.setVisible(true);
        }else if(e.getActionCommand() == "查看认证标准") {
            Mysocket ms=new Mysocket();
            ms.sendm(ms,"查看认证标准");
            try {
                ms.socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            p3.setVisible(false);
            p3.removeAll();
            p3.add(new biaozhun());
            p3.setVisible(true);
        } else if (e.getActionCommand() == "退出") {
            System.exit(0);
        }else {
            System.out.println("hekko");
            p3.setVisible(false);
            p3.removeAll();
            p3.add(new xiugai());
            p3.setVisible(true);
        }
    }
}
