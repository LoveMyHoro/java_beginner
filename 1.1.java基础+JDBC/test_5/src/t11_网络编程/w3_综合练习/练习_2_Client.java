package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class 练习_2_Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9998);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter( socket.getOutputStream()));
        bw.write("明日方舟");
        //这里的 bw.newLine()就是添加了一个换行符作为readLine的结束标志
        bw.newLine();
        bw.flush();

        //结束标记
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message=br.readLine();
        System.out.println(message);
        socket.close();

    }
}
