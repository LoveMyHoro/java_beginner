package t9_io流.j3_高级流.g4_打印流;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class 知识点_5_练习 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw=new PrintWriter(new FileWriter("F:\\java\\pw.txt"),true);
        pw.print(114);
        pw.println(98);
        pw.println("你好");
        pw.close();

    }
}
