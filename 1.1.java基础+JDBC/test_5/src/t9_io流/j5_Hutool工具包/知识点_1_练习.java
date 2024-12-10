package t9_io流.j5_Hutool工具包;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        //1.可以进行多段字符的拼接
        File file= FileUtil.file("F:\\","aaa","bbb","x.txt");
        System.out.println(file);
        //2.可以自动创建不存在的父级路径
        File touch=FileUtil.touch(file);
        System.out.println(touch);
        //3.写入列表
        ArrayList<String>list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        FileUtil.writeLines(list,"F:\\java\\a.txt","UTF-8",true);
        //4.追加
        FileUtil.appendLines(list,"F:\\java\\a.txt","UTF-8");
        //5.读取文件
        List<String> list2=FileUtil.readLines("F:\\java\\csb.txt","UTF-8");
        System.out.println(list2);

    }
}
