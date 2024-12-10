package t11_网络编程.w3_综合练习;

import java.io.*;
import java.lang.reflect.Member;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class 练习_2_Servant {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9998);
        Socket socket=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //细节：
        //read方法会从连接的通道中读取数据
        //但是，需要有一个结束标记，此处的循环才会结束
        //否则，程序会一直停在read方法这里，等待读取下面的数据
        System.out.println("开始读取数据");
        br.readLine();
        System.out.println("数据读取完毕");

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("启动");
        bw.newLine();
        bw.flush();

        socket.close();
        ss.close();
    }
}
