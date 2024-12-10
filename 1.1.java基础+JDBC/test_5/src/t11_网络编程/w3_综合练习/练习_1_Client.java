package t11_网络编程.w3_综合练习;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class 练习_1_Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        //获得输出流
        OutputStream os=socket.getOutputStream();
        Scanner sc=new Scanner(System.in);

        String str;
        do{
            System.out.println("请输入要发送的信息");
            str=sc.next();
            os.write(str.getBytes(StandardCharsets.UTF_8));

        }while(!str.equals("886"));
        os.close();
        //关闭通道
        socket.close();
    }
}
