package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class 练习_3_Servant_纯文本传输 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        Socket socket=ss.accept();

        File file=new File("F:\\copy\\c1.txt");
        FileWriter fw=new FileWriter(file);

        InputStream is=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        int b;
        while((b=isr.read())!=-1){
            fw.write((char)b );
            System.out.print((char)b);
        }
        fw.flush();

        fw.close();
        socket.close();
        ss.close();
    }
}