package t9_io流.j3_高级流.g5_解压缩流和压缩流;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class 知识点_3_练习_压缩整个文件夹{
    public static void main(String[] args) throws IOException {
        File src=new File("F:\\java\\forz");
        File dest=new File(src.getParent(),src.getName()+".zip");
        //1.创建压缩流关联压缩包(目的地)
        ZipOutputStream zip=new ZipOutputStream(new FileOutputStream(dest));
        //2.获取src中的每一个文件，变成ZipEntry对象，放入压缩包中
        Zip(src,zip, src.getName());
    }
    public static void Zip(File src,ZipOutputStream zip,String name) throws IOException {
        File[]arr=src.listFiles();
        for (File file : arr) {
            if(file.isFile()){
                ZipEntry entry=new ZipEntry(name+"\\"+file.getName());
                FileInputStream fos=new FileInputStream(file);
                int b;
                zip.putNextEntry(entry);
                while((b=fos.read())!=-1){
                    zip.write(b);
                }
                //关闭FileInputStream流
                fos.close();
                //关闭当前单个压缩文件的流，表面这个文件压缩完成，准备压缩下个文件
                zip.closeEntry();
            }
            else{
                //自动创建文件夹
                Zip(file,zip,name+"\\"+file.getName());
            }
        }
    }
}
