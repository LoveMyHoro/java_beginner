package t11_网络编程.w2_网络编程三要素.s2_ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class 知识点_8_练习 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getByName("Asuka");
        System.out.println(address);

        String name=address.getHostName();
        System.out.println(name);

        String ip= address.getHostAddress();
        System.out.println(ip);

    }
}
