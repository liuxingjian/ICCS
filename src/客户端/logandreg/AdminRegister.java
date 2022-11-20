package 客户端.logandreg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

/*
 * 管理员注册界面
 *
 */
public class AdminRegister extends JFrame {
    String sm;
    String name = null;
    String s;
    Socket socket = null;
    BufferedReader br = null;
    BufferedWriter bw = null;

    AdminRegister(Socket socket, BufferedReader br, BufferedWriter bw) {
        this.socket = socket;
        this.br = br;
        this.bw = bw;
        init();
    }

    void init() {
        JFrame frame = new JFrame("注册管理员账号");
        frame.setLayout(null);

        JLabel IDStr = new JLabel("账号:");
        IDStr.setBounds(250, 200, 100, 25);
        frame.add(IDStr);

        JLabel passwordStr = new JLabel("密码:");
        passwordStr.setBounds(250, 250, 100, 25);
        frame.add(passwordStr);

        JLabel confrimStr = new JLabel("确认密码:");
        confrimStr.setBounds(250, 300, 100, 30);
        frame.add(confrimStr);

        JTextField userID = new JTextField();
        userID.setBounds(320, 200, 150, 25);
        frame.add(userID);

        JPasswordField password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        frame.add(password);

        JPasswordField confrimPassword = new JPasswordField();
        confrimPassword.setBounds(320, 300, 150, 25);
        frame.add(confrimPassword);

        JButton buttonregister = new JButton("注册");
        buttonregister.setBounds(350, 350, 70, 25);
        frame.add(buttonregister);

        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //为注册按钮增加监听器
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ID = userID.getText();
                String passwd = new String(password.getPassword());
                String confrimpasswd = new String(confrimPassword.getPassword());
                if (!passwd.equals(confrimpasswd)) {
                    JOptionPane.showMessageDialog(null, "密码有误", "错误", JOptionPane.NO_OPTION);
                } else {
                    String data =  ID + "#" + passwd;
                    sendreg(socket, br, bw, data);
                    JOptionPane.showMessageDialog
                            (null, s, "message",
                                    JOptionPane.NO_OPTION);
                    frame.setVisible(false);
                    new Login_Register();
                }
            }
        });
    }

    public void sendreg(Socket socket, BufferedReader br, BufferedWriter bw, String data
    ) {
        String m = "1";
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


