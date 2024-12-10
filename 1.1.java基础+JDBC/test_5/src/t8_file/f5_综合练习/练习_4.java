package t8_file.f5_综合练习;

import java.io.File;

public class 练习_4 {
    public static void main(String[] args) {
        File file=new File("D:\\Users\\iove\\OneDrive\\桌面\\Student");
        Delete(file);
    }
    public static void Delete(File src){
        if(src==null){
            return;
        }
        File []files=src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }
            else{
                Delete(file);
            }
        }
        src.delete();

    }
}
