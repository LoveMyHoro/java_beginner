package project4_控制台聊天室.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{
    private Socket socket;
    public MyThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        Socket sc=this.socket;
        while (true){
            try {
                BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
                String message=br.readLine();
                System.out.println(message);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
