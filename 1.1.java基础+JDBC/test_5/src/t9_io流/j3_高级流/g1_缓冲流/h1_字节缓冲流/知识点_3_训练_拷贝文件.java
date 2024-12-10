package t9_io流.j3_高级流.g1_缓冲流.h1_字节缓冲流;

import java.io.*;

public class 知识点_3_训练_拷贝文件 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\java.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\copy.txt"));
        byte []arr=new byte[10];
        int len=0;
        while((len=bis.read(arr))!=-1){
                bos.write(arr,0,len);
        }
        bos.close();
        bis.close();

    }
}
