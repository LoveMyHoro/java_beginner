package t9_io流.j3_高级流.g5_解压缩流和压缩流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class 知识点_3_练习_压缩单个文件 {
    public static void main(String[] args) throws IOException {
        File src=new File("F:\\java\\csb.txt");
        File dest=new File("F:\\copy");
        Zip(src,dest);
    }

    private static void Zip(File src, File dest) throws IOException {
        //1.创建压缩流，关联压缩包
        ZipOutputStream zos=new ZipOutputStream( new FileOutputStream(new File(dest,"a.zip")));
        //2.创建ZipEntry对象，表示压缩包内的文件
        ZipEntry entry=new ZipEntry("a.txt");
        //3.把ZipEntry放进压缩包中
        zos.putNextEntry(entry);
        //由于entry是空的，所以要把要压缩的数据写进entry中
        FileInputStream fis=new FileInputStream(src);
        int b;
        while((b=fis.read())!=-1){
            zos.write(b);
        }
        fis.close();
        //关闭当前Entry文件的流
        zos.closeEntry();
        //关闭压缩包的流
        zos.close();

    }
}
