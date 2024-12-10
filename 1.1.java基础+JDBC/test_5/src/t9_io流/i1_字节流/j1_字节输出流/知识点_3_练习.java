package t9_io流.i1_字节流.j1_字节输出流;

import java.io.FileOutputStream;
import java.io.IOException;

public class 知识点_3_练习 {
    public static void main(String[] args) throws IOException {
        FileOutputStream file=new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶\\aaa.txt");
        byte []arr={97,98,99,100,101};
        //写入数组全部内容
        //file.write(arr);
        //写入数组部分数据
        //off:起始位置，len:写入的长度
        file.write(arr,2,3);
        file.close();

    }
}
