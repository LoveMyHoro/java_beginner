package t8_file.f4_常见的成员方法_获取并遍历;

import java.io.File;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        File f1=new File("D:\\java");
        File []file=f1.listFiles();
        for (File file1 : file) {
            System.out.println(file1);
        }
    }
}
