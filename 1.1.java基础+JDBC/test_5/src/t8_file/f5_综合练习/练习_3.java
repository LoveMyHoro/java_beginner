package t8_file.f5_综合练习;

import java.io.File;
import java.util.Arrays;

public class 练习_3 {
    public static void main(String[] args) {
        /*
        套路：
            1.进入文件夹
            2.遍历数组
            3.判断
            4.判断
         */
        File []files=File.listRoots();
        for (File file : files) {
            Find(file);
        }
    }

    public static void Find(File src){
        //1.进入文件夹src
        File []files=src.listFiles();
        if(files==null){
            return;
        }
        //2.遍历数组，依次得到src里面的每一个文件或者文件夹
        for (File file : files) {
            //3.判断，如果是文件，就可以执行题目的要求
            if(file.isFile()){
                if(file.getName().endsWith("mp4")){
                    System.out.println(file);
                }
            }
            //4.判断，如果是文件夹，就可以递归
            else{
                Find(file);
            }
        }

    }

}
