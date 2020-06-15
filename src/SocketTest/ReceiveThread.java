package SocketTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread implements Runnable {
    private Socket socket;
    public ReceiveThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while(true){
                String msg = dataInputStream.readUTF();
                System.out.println("msg:" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
