package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class 练习_5_Servant {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        while(true){
            Socket socket=ss.accept();
            MyThread m=new MyThread(socket);
            m.start();
        }
        //ss.close();
    }
}
