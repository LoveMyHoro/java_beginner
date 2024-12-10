package t9_io流.i1_字节流.j2_字节输入流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class 知识点_4_练习_文件拷贝 {
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\One Last Kiss-宇多田ヒカル.mp3");
        FileOutputStream file2=new FileOutputStream("F:\\java\\copy.mp4");
        int b;
        while((b=file.read())!=-1){
            file2.write(b);
            System.out.println(b);
        }
        file2.close();
        file.close();
    }
}
