package t11_网络编程.w3_综合练习;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 小案例 {
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\java\\ClassName.txt");
        FileReader fr=new FileReader(file);
        FileWriter fw=new FileWriter("F:\\copy\\ClassName.txt");
        int b;
        while((b=fr.read())!=-1){
            fw.write((char)b );
        }
        fw.close();
        fr.close();
    }
}
