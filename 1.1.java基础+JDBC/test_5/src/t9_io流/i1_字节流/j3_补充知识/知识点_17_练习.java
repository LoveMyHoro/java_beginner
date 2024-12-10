package t9_io流.i1_字节流.j3_补充知识;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class 知识点_17_练习 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //1.编码
        String str="ai你呦";
        //默认编码方式为Unicode
        byte []byte1=str.getBytes();
        System.out.println(Arrays.toString(byte1));

        //指定编码方式为GBK
        byte []byte2=str.getBytes("GBK");
        System.out.println(Arrays.toString(byte2));

        //2.解码
        String str2=new String(byte1);
        System.out.println(str2);

        String str3=new String(byte2);
        System.out.println(str3);


    }
}
