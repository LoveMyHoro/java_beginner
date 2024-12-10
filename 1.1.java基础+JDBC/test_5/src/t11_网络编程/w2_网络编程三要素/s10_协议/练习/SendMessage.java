package t11_网络编程.w2_网络编程三要素.s10_协议.练习;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMessage {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket();
        String text;
        do{
            System.out.println("请输入要发送的数据：");
            text=sc.next();
            Send(text,ds);
        }while(!"886".equals(text));
    }

    private static void Send(String str,DatagramSocket ds) throws IOException {
        byte[]bytes=str.getBytes();
        InetAddress address=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,address,10086);
        ds.send(dp);
        ds.close();
    }
}
