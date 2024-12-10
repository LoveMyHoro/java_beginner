package t9_io流.j6_综合练习.练习_6_每日一记_io最终大作业.com.itheima.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyThreadInput extends Thread{
    @Override
    public void run() {
        try {
                ZipInputStream zis=new ZipInputStream(new FileInputStream("F:\\java\\tabledatas.zip"));
                ZipEntry entry;
                while((entry=zis.getNextEntry())!=null){
                    if(entry.isDirectory()){
                        File file1=new File(entry.toString());
                        file1.mkdir();
                    }
                    else{
                        FileOutputStream fos=new FileOutputStream(new File("F:\\java",entry.toString()));
                        int b;
                        while((b=zis.read())!=-1){
                            fos.write(b);
                        }
                        fos.close();
                    }
                }
                zis.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
    }
}
