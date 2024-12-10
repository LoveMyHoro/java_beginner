package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.net.*;

public class 知识点_6_1_练习_组播_接收端1 {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms=new MulticastSocket(10000);
        //将当前本机，添加到224.0.0.2的这一组中
        InetAddress address=InetAddress.getByName("224.0.0.2");
        ms.joinGroup(address);

        //2.接收数据包
        byte[]arr=new byte[1024];
        DatagramPacket dp=new DatagramPacket(arr, arr.length);

        //该方法是阻塞的，程序执行到了这里会死等，直到接收到了数据
        ms.receive(dp);

        //3.解析数据包
        byte[]data=dp.getData();
        int len=dp.getLength();
        System.out.println("长度："+len);
        System.out.println("接收到的数据："+new String(data,0,len));
        ms.close();
    }
}
