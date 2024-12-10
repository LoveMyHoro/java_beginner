package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLOutput;

public class 知识点_5_练习_接收数据 {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象(寻找快递公司)
        //细节：
        //在接收的时候一定要绑定端口
        //而且绑定的端口一定要和发送的端口保持一致
        DatagramSocket ds=new DatagramSocket(10086);

        //2.接收数据包
        byte[]arr=new byte[1024];
        DatagramPacket dp=new DatagramPacket(arr, arr.length);

        //该方法是阻塞的，程序执行到了这里会死等，直到接收到了数据
        System.out.println("接收前");
        ds.receive(dp);
        System.out.println("接收后");

        //3.解析数据包
        byte[]data=dp.getData();
        int len=dp.getLength();
        System.out.println("长度："+len);
        InetAddress address=dp.getAddress();
        int port=dp.getPort();
        System.out.println("接收到的数据："+new String(data,0,len));
        System.out.println("该数据来自"+address+",端口号为:"+port);
    }
}
