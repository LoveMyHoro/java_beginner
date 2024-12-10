package t9_io流.j3_高级流.g2_转换流_让字节流使用字符流的方法.练习;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class 练习_1 {
    public static void main(String[] args) throws IOException {
        //1.FileReader 指定字符编码读入数据(GBK)
        FileReader fr=new FileReader("F:\\java\\GBK.txt", Charset.forName("GBK"));
        int len;
        while((len=fr.read())!=-1){
            //System.out.print((char)len);
        }
        fr.close();
        //2.FileWriter 指定字符编码写出数据(GBK)
        FileWriter fw=new FileWriter("F:\\copy\\GBK.txt",Charset.forName("GBK"));
        fw.write("明日方舟,启动！");
        fw.close();

        //3.将GBK文件转为UTF-8文件
        FileReader fr2=new FileReader("F:\\java\\GBK.txt", Charset.forName("GBK"));
        FileWriter fw2=new FileWriter("F:\\copy\\UTF-8.txt",Charset.forName("UTF-8"));
        int len2;
        while((len2=fr2.read())!=-1){
            fw2.write((char)len2);
        }
        fr2.close();

    }
}
