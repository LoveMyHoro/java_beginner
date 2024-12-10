package t8_file.f1_基本原理;

import java.io.File;

public class 知识点_1_训练 {
    public static void main(String[] args) {
        //1.根据字符串表示的路径，变成File对象
        String str="C:\\Users\\iove\\OneDrive\\桌面\\java.txt";
        File f1=new File(str);
        System.out.println(f1);


        //2.父路径："C:\\Users\\iove\\OneDrive\\桌面”
        //  子路径："java.txt"
        String parent="C:\\Users\\iove\\OneDrive\\桌面";
        String child="java.txt";
        File f2=new File(parent,child);
        System.out.println(f2);


        //3.把一个File表示的路径和一个String表示的路径进行拼接
        File parent2=new File("C:\\Users\\iove\\OneDrive\\桌面");
        String child2="java.txt";
        File f4=new File(parent2,child2);
        System.out.println(f4);


    }
}
