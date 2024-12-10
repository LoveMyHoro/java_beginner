package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class 知识点_8_2_Servant {
    public static void main(String[] args) throws IOException {
        //1.创建服务器对象
        ServerSocket ss=new ServerSocket(9999);
        //2.监听客户端的连接，这个方法是阻塞的
        Socket socket=ss.accept();
        //3.从连接通道中获取输入流读取数据
        InputStream is=socket.getInputStream();
        InputStreamReader ir=new InputStreamReader(is);
        int b;
        while((b=ir.read())!=-1){
            System.out.print((char)b);
        }
        socket.close();
        ss.close();

    }
}
