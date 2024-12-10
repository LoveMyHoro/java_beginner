package t8_file.f5_综合练习;

import java.io.File;
import java.io.IOException;

public class 练习_1 {
    public static void main(String[] args) throws IOException {
        File f1=new File("D:\\java\\code\\test_5\\aaa");
        System.out.println(f1.mkdir());
        File sc=new File(f1,"a.txt");
        System.out.println(sc.createNewFile());

    }
}
