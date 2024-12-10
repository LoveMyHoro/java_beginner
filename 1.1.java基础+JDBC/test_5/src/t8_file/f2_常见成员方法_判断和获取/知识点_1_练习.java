package t8_file.f2_常见成员方法_判断和获取;

import java.io.File;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        //1.判断存在的方法
        //(1)桌面上上的文档
        File f1=new File("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println("---------------------------------------");
        //(2)桌面上的文件夹
        File f2=new File("D:\\java");
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.exists());
        System.out.println("---------------------------------------");


        //2.length返回大小
        //注意：这个方法只能获取文件的大小，单位是字节。不能获取文件夹的大小
        // (1)返回文件的大小
        System.out.println(f1.length());
        // (2)返回文件夹的大小
        System.out.println(f2.length());
        System.out.println("------------------------------");
        //3.getAbsolutePath获取文件的绝对路径
        String path=f1.getAbsolutePath();
        System.out.println(path);
        System.out.println("==============================");
        //4.返回创建对象时的路径
        System.out.println(f1.getPath());
        System.out.println("==============================");
        //5.获取文件名称
        System.out.println(f1.getName());
        System.out.println(f2.getName());
        System.out.println("==============================");
        //6.lastModified返回文件最后的修改时间
        System.out.println(f1.lastModified());

    }
}
