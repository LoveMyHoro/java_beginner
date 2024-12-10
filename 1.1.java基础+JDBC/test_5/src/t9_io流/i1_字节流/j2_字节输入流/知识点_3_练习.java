package t9_io流.i1_字节流.j2_字节输入流;

import java.io.FileInputStream;
import java.io.IOException;

public class 知识点_3_练习 {
    //循环读入数据
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt");
        int b;
        while((b=file.read())!=-1){

            System.out.print((char)b);
        }
        file.close();
    }
}
