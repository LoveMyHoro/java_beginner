package t6_方法引用;

import t1_集合进阶.进阶7_双列集合.s2_HashMap.练习_1.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 知识点_6_练习 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list, "明日香,7","战场原,14","赫萝,15");
        //stream方法
        List<Student>newlist=list.stream().map(s->{
            String name=s.split(",")[0];
            int age=Integer.parseInt(s.split(",")[1]);
            return new Student(name,age);
        }).collect(Collectors.toList());
        System.out.println(newlist);
        //引用方法
        //需要注意：被引用方法的形参和返回值要和抽象方法保持一致
        List<t6_方法引用.Student>list1=list.stream().map(t6_方法引用.Student::new).collect(Collectors.toList());
        System.out.println(list1);

    }
}
