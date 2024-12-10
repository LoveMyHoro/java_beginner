package t9_io流.j4_Commons_io工具包;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class 知识点_2_练习 {
    public static void main(String[] args) throws IOException {
        //复制单个文件
        File src=new File("F:\\java\\csb.txt");
        File dest=new File("F:\\copy\\util.txt");
        FileUtils.copyFile(src,dest);
        //复制文件夹
        File src2=new File("F:\\java\\trash");
        File dest2=new File("F:\\copy\\trash");
        FileUtils.copyDirectory(src2,dest2);

    }
}
