package 客户端.teacher;


import 服务器.Server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Client_c extends JPanel implements Runnable,ActionListener {

    private JTextField field = new JTextField(20);
    private JTextArea area = new JTextArea("在线聊天室：\n");
    private JButton jButton1=new JButton("再见");
    private JButton jButton=new JButton("发送");

    private JPanel jPanel=new JPanel();

    private String name = null;

    private int Port = 9998;
    private DatagramSocket DS;

    public Client_c(){

        area.setEnabled(false);
        area.setBackground(Color.yellow);
        area.setSize(400,1000);
        area.setDisabledTextColor(Color.RED);
        this.setLayout(new BorderLayout());
       // this.setTitle("客户端");
     //   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(area, BorderLayout.CENTER);
        this.add(jPanel,BorderLayout.SOUTH);
        jPanel.add(field);
        jPanel.add(jButton1);
        jPanel.add(jButton);
        jButton.addActionListener(this);
        jButton1.addActionListener(this);
        this.setSize(400,1000);
        this.setVisible(true);

        name = JOptionPane.showInputDialog("输入昵称");

        try {
            DS = new DatagramSocket();
            InetAddress address = InetAddress.getByName("Localhost");
            DS.connect(address,Port);

            String str = name + "登录!";
            byte[] data = str.getBytes();
            DatagramPacket DP = new DatagramPacket(data,data.length);

            DS.send(DP);
            new Thread(this).start();

        } catch (Exception e) {
        }
    }
    public void run(){
        try{
            while(true){
                byte[] data = new byte[255];
                DatagramPacket DP = new DatagramPacket(data,data.length);
                DS.receive(DP);
                String str = new String(DP.getData(),0,DP.getLength());
                area.append(str + '\n');
            }
        }catch(Exception ex){
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="发送"){
            try{
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
                String st= "<== "+dateFormat.format(new Date())+" ==>"+"\n";

                String str = st+name + "说：" + field.getText();
                byte[] dd = str.getBytes();
                DatagramPacket Data = new DatagramPacket(dd,dd.length);
                DS.send(Data);
                field.setText("");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            this.setVisible(false);
        }

    }
}

