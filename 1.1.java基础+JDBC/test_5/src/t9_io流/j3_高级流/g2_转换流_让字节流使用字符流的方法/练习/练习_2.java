package t9_io流.j3_高级流.g2_转换流_让字节流使用字符流的方法.练习;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 练习_2 {
    public static void main(String[] args) throws IOException {
        //1.将字节流利用转换流转换为字符流读取中文，再转换成缓冲流每次读取一整行
        //注意：这里读入的是GBK文本，所以要指定编码形式
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("F:\\java\\GBK.txt"),"GBK"));
        String len;
        while((len=br.readLine())!=null){
            System.out.println((len));
        }
        br.close();
    }
}
