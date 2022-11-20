package 客户端.logandreg;

import 客户端.Mysocket;
import 客户端.admin.Adminmenu;
import 客户端.student.Studentmenu;
import 客户端.teacher.teachermenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;


public class Login_Register extends JFrame{
    String sm;
    String s;
    Socket socket=null;
    BufferedReader br=null;
    BufferedWriter bw=null;
    public Login_Register() {
        Mysocket m=new Mysocket();
        this.socket=m.socket;
        this.br=m.getBr();
        this.bw=m.getBw();
        init();
    }
    //登录界面初始化
    public void init() {
        JFrame frame = new JFrame("登录");
        frame.setLayout(null);

        JPanel jp=new JPanel();
        jp=(JPanel)frame.getContentPane();
        jp.setOpaque(false);

        JLabel nameStr = new JLabel("账号:");
        nameStr.setBounds(250, 200, 100, 25);
        frame.add(nameStr);

        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);

        JTextField userID = new JTextField();
        userID.setBounds(300, 200, 150, 25);
        frame.add(userID);

        JPasswordField password = new JPasswordField();
        password.setBounds(300, 250, 150, 25);
        frame.add(password);

        JRadioButton jrb1=new JRadioButton("管理员");			//创建单选框
        JRadioButton jrb2=new JRadioButton("学生");
        JRadioButton jrb3=new JRadioButton("老师");
        JPanel j1=new JPanel();
        j1.setBounds(250,300,200,25);
        ButtonGroup bg=new ButtonGroup();				//创建按钮组
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        j1.add(jrb1);
        j1.add(jrb2);
        j1.add(jrb3);
        frame.add(j1);


        JButton buttonlogin = new JButton("登录");
        buttonlogin.setBounds(275, 350, 70, 25);
        frame.add(buttonlogin);

        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(375, 350, 70, 25);
        frame.add(buttonregister);

        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //为登录按钮添加监听器
        buttonlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());

                String name=null;
                Enumeration<AbstractButton> radioBtns=bg.getElements();
                while (radioBtns.hasMoreElements()) {
                    AbstractButton btn = radioBtns.nextElement();
                    if(btn.isSelected()){
                        name=btn.getText();
                        break;
                    }
                }

                System.out.println(name);
                sendlogin(socket,br,bw,name,ID,passwd);

                JOptionPane.showMessageDialog(null, s, "信息", JOptionPane.NO_OPTION);
                    //点击确定后会跳转到主窗口
                    frame.setVisible(false);

                    if(s.startsWith("学生")){
                        new Studentmenu();
                    }else if(s.startsWith("老师")){
                        new teachermenu();
                    }else if(s.startsWith("管理员")){
                        new Adminmenu();
                    }
               //     new Studentmenu();
                }
        });

        //为注册按钮添加监听器
        buttonregister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //注册页面
                String name=null;
                Enumeration<AbstractButton> radioBtns=bg.getElements();
                while (radioBtns.hasMoreElements()) {
                    AbstractButton btn = radioBtns.nextElement();
                    if(btn.isSelected()){
                        name=btn.getText();
                        break;
                    }
                }

                if(name.equals("管理员")){
                    frame.setVisible(false);
                    new AdminRegister(socket,br,bw);
                }else{
                    JOptionPane.showMessageDialog(null, "无权限，请联系管理员", "error", JOptionPane.NO_OPTION);
                }

            }
        });
    }
    public void sendlogin(Socket socket,BufferedReader br,BufferedWriter bw,String name,
                          String id,String password){
        String data = name + "#" + id + "#" + password;
        String m = "0";
        try {
            bw.write(m);
            bw.newLine();
            System.out.println(m);
            bw.flush();
            bw.write(data);
            bw.newLine();
            bw.flush();
            System.out.println(data);
            //因为在注册和登录线程中都是使用的bw.write()，就是通过网络想客户端发送结果
            //所以，客户的必须也进行接收数据
            s = br.readLine();
            System.out.println(s);
            bw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



