package t9_io流.i1_字节流.j1_字节输出流;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

public class 知识点_4_练习 {
    public static void main(String[] args) throws IOException {
        //1.写入换行操作
        //（1）不同操作系统换行符：windows:\r\n,Linux:\n,Mac:\r
        FileOutputStream file=new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt");
        file.write("java".getBytes(StandardCharsets.UTF_8));
        //利用输出换行符来换行
        file.write("\r\n".getBytes(StandardCharsets.UTF_8));
        file.write("666".getBytes(StandardCharsets.UTF_8));
        file.close();
        //2.续写操作
        //在创建FileOutputStream文件的时候打开续写开关，默认为false
        FileOutputStream file2=new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt", true);
        file2.write("this is mygo".getBytes(StandardCharsets.UTF_8));
        file2.close();
    }
}
