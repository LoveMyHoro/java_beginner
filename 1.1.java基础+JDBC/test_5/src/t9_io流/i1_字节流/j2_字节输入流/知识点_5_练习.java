package t9_io流.i1_字节流.j2_字节输入流;

import java.io.FileInputStream;
import java.io.IOException;

public class 知识点_5_练习 {
    //如果看不懂原理可见视频p84
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt");
        byte []bytes=new byte[2];
        int len=0;
        while((len=file.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
        file.close();
    }
}
