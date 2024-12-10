package t5_Stream流;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class 知识点_4_练习 {
    public static void main(String[] args) {
        //1.filter过滤
        ArrayList<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.print(name+" "));
        System.out.println();
        //2.limit获取前几个元素
        list.stream()
                .limit(3)
                .forEach(name-> System.out.print(name+" "));
        System.out.println();
        //3.跳过前几个元素
        list.stream()
                .skip(3)
                .forEach(name-> System.out.printf(name+" "));
        System.out.println();
        //练习：只获取赵敏
        list.stream()
                .skip(2)
                .limit(1)
                .forEach(name-> System.out.println(name));
        //4.distinct去重
        //加入重复元素
        list.add("周芷若");
        list.add("赵敏");
        list.stream()
                .distinct()
                .forEach(name-> System.out.printf(name+" "));
        System.out.println();
        System.out.println("--------------------------------");
        //5.concat合并两个流
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"明日香","战场原","赫萝");
        Stream.concat(list.stream(),list2.stream())
                .forEach(name-> System.out.printf(name+" "));
        //6.Map：转换流中的数据类型
        ArrayList<String>list3=new ArrayList<>();
        Collections.addAll(list3,"明日香-15","战场原-16","赫萝-18");
        System.out.println();
        System.out.println("-------------------------------------");
        //当我们只想要数字时
        list3.stream()
                .map((String temp)->{
                     String i=temp.split("-")[1];
                     return Integer.parseInt(i);
                })
                .forEach(i-> System.out.print(i+" "));



    }
}
