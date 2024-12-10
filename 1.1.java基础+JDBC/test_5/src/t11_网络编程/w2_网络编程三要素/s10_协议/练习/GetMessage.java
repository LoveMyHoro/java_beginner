package t11_网络编程.w2_网络编程三要素.s10_协议.练习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GetMessage {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(10086);

        //2.接收数据包
        byte[]arr=new byte[1024];
        DatagramPacket dp=new DatagramPacket(arr, arr.length);

        //该方法是阻塞的，程序执行到了这里会死等，直到接收到了数据
        String str;
        do{
            str=Get(ds,dp);
        }while(!str.equals("886"));
    }

    private static String Get(DatagramSocket ds, DatagramPacket dp) throws IOException {
        ds.receive(dp);

        //3.解析数据包
        byte[]data= dp.getData();
        int len= dp.getLength();
        String message=new String(data,0,len);
        System.out.println("接收到的数据："+message);
        return message;
    }

}
