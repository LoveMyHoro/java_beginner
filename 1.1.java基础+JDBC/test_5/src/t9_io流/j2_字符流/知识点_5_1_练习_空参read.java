package t9_io流.j2_字符流;

import java.io.FileReader;
import java.io.IOException;

public class 知识点_5_1_练习_空参read {
    public static void main(String[] args) throws IOException {
        FileReader file=new FileReader("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        int b;
        //file.read读取二进制数据后将其解码为十进制形式返回
        while((b=file.read())!=-1){
            System.out.print((char)b);
        }
        file.close();
    }
}
