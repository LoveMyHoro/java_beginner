package t9_io流.j2_字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class 知识点_10_练习 {
    public static void main(String[] args) throws IOException {
        FileReader file=new FileReader("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        //这里file调用read，最大8192个数据调入缓冲区，下面FileWriter清空java.txt数据时不影响缓冲区的数据，但
        //源文件已被清空
        file.read();
        FileWriter file2=new FileWriter("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        int str;
        while((str=file.read())!=-1){
            System.out.print((char)str);
        }
        file2.close();
        file.close();
    }

}
