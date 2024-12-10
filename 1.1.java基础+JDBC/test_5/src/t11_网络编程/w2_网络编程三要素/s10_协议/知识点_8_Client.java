package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class 知识点_8_Client {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象
        //细节：在创建对象的同时会连接服务器
        //     如果连不上，代码会报错
        Socket socket=new Socket("127.0.0.1",9999);

        //2.可以从连接通道中获取连接流
        OutputStream os=socket.getOutputStream();
        //写出数据
        os.write("明日方舟".getBytes(StandardCharsets.UTF_8));
        //3.释放资源
        os.close();
        socket.close();

    }
}
