package t9_io流.j2_字符流;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class 知识点_5_2_练习_含参read {
    public static void main(String[] args) throws IOException {
        FileReader file=new FileReader("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        int len=0;
        char []arr=new char[10];
        //把读取字节，解码，强转三步结合到了一起
        while((len=file.read(arr))!=-1){
            System.out.print(new String(arr,0,len));
        }

        file.close();
    }
}
