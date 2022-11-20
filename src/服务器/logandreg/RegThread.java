package 服务器.logandreg;

import Mysql.Mysql;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//注册线程
public class RegThread extends Thread{
    private Connection conn;
    String userName;	//获取的是用户名
    String userPsd;	//获取的是密码
    Socket socket = null;
    BufferedReader br = null;
    BufferedWriter bw = null;
    public RegThread(Socket socket,BufferedReader br,BufferedWriter bw) {
        this.conn = new Mysql().conn();
        this.socket=socket;
        this.br=br;
        this.bw=bw;
    }

    @Override
    public void run() {
        try {
            //处理数据
            if (null != socket) {
                //输入输出流和要写入的文件
                String data = br.readLine();
                //这里将客户端输入的信息以“#”号区分用户名和密码
                String[] datas = data.split("#");
                System.out.println(datas);

                userName = datas[0];	//获取的是用户名
                userPsd = datas[1];	//获取的是密码
                if(addAdmin()){
                    bw.write("服务器说：注册成功！！！");
                }else{
                    bw.write("服务器说：注册失败！！！");
                }
                bw.newLine();
                bw.flush();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                br.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //向数据库添加Admin账户
    boolean addAdmin() throws ClassNotFoundException, SQLException {

        try {
            String sql="insert into admin (account,password) values(?,?)";

            PreparedStatement ptmt=conn.prepareStatement(sql);

            ptmt.setString(1,userName);

            ptmt.setString(2,userPsd);
            System.out.println(userName+userPsd+"---");
            ptmt.execute();

            System.out.println("注册成功");
            conn.close();
            return true;

        }catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("!!!!!!!!!");
            System.out.println("添加用户失败！");
            return false;
        }
    }
}




