package t9_io流.j3_高级流.g4_打印流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class 知识点_3_练习 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintStream ps=new PrintStream(new FileOutputStream("F:\\java\\ps.txt"),true,"UTF-8");
        ps.println(true);
        ps.println(98);
        ps.println("原始群");
        ps.close();
    }
}
