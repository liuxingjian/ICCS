package 客户端;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Mysocket {
    public Socket socket = null;
    BufferedWriter bw = null;
    BufferedReader br = null;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public Mysocket(){
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostName(), 8888);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public  void sendm(Mysocket ms, String m){

        BufferedWriter bw=ms.getBw();
        BufferedReader br=ms.getBr();

        try {
            bw.write(m);
            bw.newLine();
            bw.flush();
            bw.close();
            br.close();
            ms.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
