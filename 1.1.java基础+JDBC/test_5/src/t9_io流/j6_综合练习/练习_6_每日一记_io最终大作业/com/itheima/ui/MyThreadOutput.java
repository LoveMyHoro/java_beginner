package t9_io流.j6_综合练习.练习_6_每日一记_io最终大作业.com.itheima.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyThreadOutput extends Thread{
    @Override
    public void run() {
        File file=new File("F:\\java\\tabledatas.data");
        try {
            ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(new File("F:\\java\\tabledatas.zip")));
            ZipEntry entry=new ZipEntry("tabledatas.data");
            zos.putNextEntry(entry);
            FileInputStream fis=new FileInputStream(file);
            int b;
            while((b=fis.read())!=-1){
                zos.write(b);
            }
            fis.close();
            zos.closeEntry();
            zos.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
