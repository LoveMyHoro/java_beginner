package t9_io流.i1_字节流.j2_字节输入流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 知识点_5_练习_根据知识点_5对文件拷贝进行改写 {
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\One Last Kiss-宇多田ヒカル.mp3");
        FileOutputStream file2=new FileOutputStream("F:\\java\\aaaaa.mp3");
        byte []bytes=new byte[1024*1024*4];
        int len=0;
        while((len=file.read(bytes))!=-1){
            file2.write(bytes,0,len);
        }
        file2.close();
        file.close();
    }
}
