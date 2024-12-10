package t9_io流.i1_字节流.j2_字节输入流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class 知识点_1_练习 {
    //注:当read读数据读不到了就会返回-1
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt");
        System.out.println((char)file.read());
        file.close();
    }
}
