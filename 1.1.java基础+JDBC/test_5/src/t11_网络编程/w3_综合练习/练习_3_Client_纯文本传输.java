package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.Socket;

public class 练习_3_Client_纯文本传输 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        File file=new File("F:\\java\\ClassName.txt");
        FileReader fr=new FileReader(file);

        OutputStream os=socket.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os);
        int b;
        while((b=fr.read())!=-1){
            osw.write((char)b);
            System.out.print((char) b);
        }
        //注意：有缓冲区的流不能通过socket直接关闭，需要手动close或者利用flush刷新数据
        //保证缓冲区的数据可以成功发送
        osw.flush();//也可以写osw.close
        fr.close();
        socket.close();

    }
}