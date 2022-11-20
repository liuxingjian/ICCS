package 服务器.liaotian;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class Server_c implements Runnable{

    private DatagramSocket DS;
    private int Port = 9998;

    private ArrayList<SocketAddress> clients = new ArrayList<SocketAddress>(); //保存客户端IP地址

    public Server_c() throws Exception{
        try {
            DS = new DatagramSocket(Port);
            new Thread(this).start();
        } catch (Exception ex) {
        }
    }
    public void run(){
        try{
            while(true){
                byte[] data = new byte[255];
                DatagramPacket DP = new DatagramPacket(data,data.length);
                DS.receive(DP);

                SocketAddress clientip = DP.getSocketAddress();

                if(!clients.contains(clientip)){
                    clients.add(clientip);
                }
                this.sendAll(DP);
            }
        }catch(Exception ex){
        }
    }
    private void sendAll(DatagramPacket dp) throws Exception {
        for(SocketAddress sa : clients){
            DatagramPacket dd = new DatagramPacket(dp.getData(),dp.getLength(),sa);
            DS.send(dd);
        }
    }

}
