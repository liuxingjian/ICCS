package 服务器.logandreg;

import Mysql.Mysql;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//登录线程
public class LoginThread extends Thread {
    private Connection conn;
    Socket socket=null;
    BufferedReader br=null;
    BufferedWriter bw=null;

    public LoginThread(Socket sc,BufferedReader br,BufferedWriter bw) {
        conn=new Mysql().conn();
       this.socket=sc;
       this.br=br;
       this.bw=bw;
    }

    @Override
    public void run() {
        try{
        String data = br.readLine();
        System.out.println(data);
        String[] datas = data.split("#");
        String name = datas[0];
        String userName = datas[1];
        String userPsd = datas[2];
        System.out.println(name+userName+userPsd);
        //判断用户名key是否存在
        String sql = null;
        if (name.equals("管理员")) {
            sql = "select * from admin where account=? and password=?";
        } else if (name.equals("学生")) {
            sql = "select * from student where account=? and password=?";
        } else if (name.equals("老师")) {
            sql = "select * from teacher where account=? and password=?";
        }

        PreparedStatement ps = null;
        ps = conn.prepareStatement(sql);

        ps.setString(1, userName);
        ps.setString(2, userPsd);
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if (rs.next()) {
            ans = 1;
        }
        rs.close();
        ps.close();
        conn.close();
        if (ans == 1) {
            System.out.println("登录成功！！！！");
            if(name.equals("管理员")){
                bw.write("管理员：登录成功！！！");
            }else if(name.equals("学生")){
                bw.write("学生：登录成功！！！");
            }else if(name.equals("老师")){
                bw.write("老师：登录成功！！！");
            }
          //  bw.write("服务器说：登录成功！！！");
            bw.newLine();
            bw.flush();
        } else {
            System.out.println();
            bw.write("服务器说：登录失败！！！！");
            bw.newLine();
            bw.flush();
        }
    } catch(Exception e){
        e.printStackTrace();
        }finally{
        try{
        assert br!=null;
        br.close();
        assert bw!=null;
        bw.close();
        socket.close();
        }catch(IOException e){
        e.printStackTrace();
        }
        }
        }
        }