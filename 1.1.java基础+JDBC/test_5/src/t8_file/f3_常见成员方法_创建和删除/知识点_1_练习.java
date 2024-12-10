package t8_file.f3_常见成员方法_创建和删除;

import java.io.File;
import java.io.IOException;

public class 知识点_1_练习 {
    public static void main(String[] args) throws IOException {
        //1.createNewFile创建新的文件
        //(1)若文件已存在则返回false
        //(2)若路父级径不存在，会报错
        File f1=new File("D:\\java\\a.txt");
        System.out.println(f1.createNewFile());

        //2.mkdir创建单级文件夹
        //(1)文件夹的名称不能重复
        //(2)只能创建单级路径
        File f2=new File("D:\\java\\abc");
        System.out.println(f2.mkdir());
        //3.mkdirs创建多级文件夹
        //(1)既可以创建单级文件夹也可以创建多级文件夹
        File f3=new File("D:\\java\\aaa\\aaa\\aaa");
        System.out.println(f3.mkdirs());
        //4.delete删除
        //(1)如果删除的是文件时，直接删除不走回收站
        //(2)如果删除的是空文件夹时，直接删除
        //   如果是有内容的文件夹时，删除失败

        System.out.println(f2.delete());
    }
}
