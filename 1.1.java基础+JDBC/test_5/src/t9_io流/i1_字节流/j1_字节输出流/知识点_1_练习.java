package t9_io流.i1_字节流.j1_字节输出流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class 知识点_1_练习 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos= new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\a.txt");
        fos.write(97);
        fos.close();
    }
}
