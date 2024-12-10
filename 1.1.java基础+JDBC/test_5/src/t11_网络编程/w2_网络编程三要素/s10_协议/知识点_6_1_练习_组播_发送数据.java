package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class 知识点_6_1_练习_组播_发送数据 {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();
        String s = "明日方舟";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.2");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        ms.send(dp);
        ms.close();
    }
}
