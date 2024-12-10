package t11_网络编程.w2_网络编程三要素.s10_协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 知识点_4_练习_发送数据 {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象(寻找快递公司)
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：在所有有用的端口中随机一个使用
        //有参：使用端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        String str = "明日方舟";
        byte[] arr = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(arr, arr.length, address, port);
        //3.发送数据
        ds.send(dp);
        //4.释放资源
        ds.close();

    }
}