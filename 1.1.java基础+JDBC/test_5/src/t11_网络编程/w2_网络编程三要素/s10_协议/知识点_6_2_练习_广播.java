package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class 知识点_6_2_练习_广播 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        String str = "明日方舟";
        byte[] arr = str.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(arr, arr.length, address, port);
        //3.发送数据
        ds.send(dp);
        //4.释放资源
        ds.close();
    }
}
