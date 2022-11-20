package 服务器;

import 服务器.liaotian.Server_c;
import 服务器.logandreg.LoginThread;
import 服务器.logandreg.RegThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//服务器
public class Server {
    public static void main(String[] args)  {
        try {
            new Server_c();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServerSocket listener= null;
        try {
            listener = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        System.out.println("系统已经启动！！！");
        while (true){
            try {
                //创建ServerSocke
                //监听
                socket = listener.accept();
                //处理数据
                if (null != socket) {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //线程启动

            try {
                assert br != null;
                String m= br.readLine();
                System.out.println("---->>"+m+"<<---");
                if(m.equals("1")){
                    System.out.println("regist>>>");
                    new RegThread(socket,br,bw).start();
                }
                else if(m.equals("0")){
                    System.out.println("login>>>");
                    new LoginThread(socket,br,bw).start();
                    System.out.println("--------");
                }else if(m.equals("3")){
                    System.out.println("材料>>>");

                } else if(m.equals("4")){
                    System.out.println("文件上传>>>");
                }
            } catch (IOException e) {
               // e.printStackTrace();
                System.out.println("hello");
            }
        }


    }
}

