package SocketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            new Thread(new SendThread(socket), "ServerSend").start();
            new Thread(new ReceiveThread(socket), "ServerReceive").start();
//            socket.close();
//            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//class Singleton{
//    private volatile static Singleton instance;
//    private Singleton(){}
//    public Singleton getInstance(){
//        if(instance == null){
//            synchronized(Singleton.class){
//                if(instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }
//    }
//}