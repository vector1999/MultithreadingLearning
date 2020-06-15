package SocketTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread implements Runnable{
    public Socket socket;
    public SendThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            while(true){
                Scanner scanner  = new Scanner(System.in);
                String msg = scanner.next();
                dataOutputStream.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
