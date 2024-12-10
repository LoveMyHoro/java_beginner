package t9_io流.j3_高级流.g5_解压缩流和压缩流;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class 知识点_2_练习 {
    public static void main(String[] args) throws IOException {
        //1.获取压缩包路径
        File src=new File("F:\\java\\forz.zip");
        //2.获取解压缩目的地
        File dest=new File("F:\\copy");
        //3.方法
        unZip(src,dest);
    }

    private static void unZip(File src, File dest) throws IOException {
        ZipInputStream zip=new ZipInputStream(new FileInputStream(src));
        //ZipEntry是zip压缩包中文件的存储形式
        ZipEntry entry;
        while((entry=zip.getNextEntry())!=null){
            if(entry.isDirectory()){
                File file=new File(dest,entry.toString());
                file.mkdirs();
            }
            else{
                FileOutputStream fos=new FileOutputStream(new File(dest,entry.toString()));
                int b;
                while((b=zip.read())!=-1){
                    fos.write(b);
                }
                fos.close();
            }

        }
        zip.close();
    }
}
