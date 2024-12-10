package t9_io流.j3_高级流.g1_缓冲流.h3_练习;

import com.sun.source.tree.NewArrayTree;

import java.io.*;
import java.util.Currency;

public class 练习_1 {
    public static void main(String[] args) throws IOException {
        long start,end;
        //1.字节流基本流
        start=System.currentTimeMillis();
        FileInputStream inputStream=new FileInputStream("F:\\java\\One Last Kiss-宇多田ヒカル.mp3");
        FileOutputStream outPutStream=new FileOutputStream("F:\\copy\\copy1.mp3");
        int len;
        while((len=inputStream.read())!=-1){
            outPutStream.write(len);
        }
        outPutStream.close();
        inputStream.close();
        end=System.currentTimeMillis();
        System.out.println("字节流基本流时间:"+(end-start));
        //2.字节流基本流(数组)
        start=System.currentTimeMillis();
        FileInputStream inputStream2=new FileInputStream("F:\\java\\One Last Kiss-宇多田ヒカル.mp3");
        FileOutputStream outPutStream2=new FileOutputStream("F:\\copy\\copy2.mp3");
        int len2;
        byte []bytes=new byte[1024*1024*5];
        while((len=inputStream2.read(bytes))!=-1){
            outPutStream2.write(bytes,0,len);
        }
        outPutStream2.close();
        inputStream2.close();
        end=System.currentTimeMillis();
        System.out.println("字节流基本流(数组)时间:"+(end-start));
        //3.字节缓冲流
        start=System.currentTimeMillis();
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("F:\\java\\One Last Kiss-宇多田ヒカル.mp3"));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("F:\\copy\\copy3.mp3"));
        int len3;
        while((len3=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(len3);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        end=System.currentTimeMillis();
        System.out.println("字节缓冲流时间:"+(end-start));
        //4.字节缓冲流(数组)
        start=System.currentTimeMillis();
        BufferedInputStream bufferedInputStream2=new BufferedInputStream(new FileInputStream("F:\\java\\One Last Kiss-宇多田ヒカル.mp3"));
        BufferedOutputStream bufferedOutputStream2=new BufferedOutputStream(new FileOutputStream("F:\\copy\\copy4.mp3"));
        int len4;
        byte[]bytes2=new byte[1024*1024*5];
        while((len4=bufferedInputStream2.read(bytes2))!=-1){
            bufferedOutputStream2.write(bytes2,0,len4);
        }
        bufferedOutputStream2.close();
        bufferedInputStream2.close();
        end=System.currentTimeMillis();
        System.out.println("字节缓冲流时间(数组):"+(end-start));

    }
}
