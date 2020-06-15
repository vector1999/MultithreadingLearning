package SocketTest;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            new Thread(new SendThread(socket), "ClientSend").start();
            new Thread(new ReceiveThread(socket), "ClientReceive").start();
//            socket.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
