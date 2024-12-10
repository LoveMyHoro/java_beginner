package t8_file.f5_综合练习;

import java.io.File;

public class 练习_2 {
    public static void main(String[] args) {
        Find(new File("F:\\video\\bilibili下载姬\\【音乐】Galgame 高清版OP合集"));
    }
    public static boolean Find(File file){
        File[] files=file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()&&file1.getName().endsWith("mp4")){
                System.out.println(file1);
                return true;
            }
        }
        return false;
    }
}
