package t9_io流.j2_字符流.综合练习;

import java.io.*;

public class 练习_1 {
    public static void main(String[] args) throws IOException {
        File file1=new File("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶");
        File file2=new File("F:\\copy");
        Method(file1,file2);
    }
    public static void Method(File src,File src2) throws IOException {
        if(src==null){
            return;
        }
        File []files= src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                //System.out.println(file.getName());
                FileInputStream fileInputStream=new FileInputStream(file.getAbsolutePath());
                FileOutputStream fileOutputStream=new FileOutputStream(src2.getAbsolutePath()+"\\"+file.getName());
                byte []arr=new byte[1024*1024*10];
                int len=0;
                while((len=fileInputStream.read(arr))!=-1){
                    fileOutputStream.write(arr,0,len);
                }
                fileOutputStream.close();
                fileInputStream.close();
            }
            else{
                File file1=new File(src2+"\\"+file.getName());
                file1.mkdir();
                Method(file,file1);
            }
        }
    }
}
