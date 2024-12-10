package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.Socket;

public class 练习_5_Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        File file=new File("F:\\java\\Mao.png");

        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());

        byte []bytes=new byte[1024];
        int len;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.flush();
        socket.shutdownOutput();

        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int c;
        while((c=isr.read())!=-1){
            System.out.print((char) c);
        }
        isr.close();
        bos.close();
        bis.close();
        socket.close();

    }
}
