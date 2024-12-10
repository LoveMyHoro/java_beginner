package t11_网络编程.w3_综合练习;

import javax.swing.plaf.basic.BasicFormattedTextFieldUI;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class 练习_1_Servant {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        String message;
        Socket socket=ss.accept();
        message="";
        InputStream is=socket.getInputStream();
        InputStreamReader ir=new InputStreamReader(is);
        int b;
        while((b=ir.read())!=-1){
            System.out.print((char) b);
        }
        //关闭通道
        socket.close();
        //关闭服务器
        ss.close();
    }
}
