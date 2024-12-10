package t5_Stream流.s1_练习;

import t1_集合进阶.进阶7_双列集合.s2_HashMap.练习_1.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 练习_3 {
    public static void main(String[] args) {
        ArrayList<String>manList=new ArrayList<>();
        ArrayList<String>womenList=new ArrayList<>();
        Collections.addAll(manList,"张三,14","李四也,15","杨戬,16","大哥大,26","王俊平,16","大将,15");
        Collections.addAll(womenList,"杨平平,17","战场原,16","明日香,17","赫萝,15","杨超越,28","莎莎,18");
        List<String>list1 =manList.stream().filter(s->s.split(",").length==3).limit(2).collect(Collectors.toList());
        List<String>list2=womenList.stream().skip(1).filter(s->s.split(",")[0].startsWith("杨")).collect(Collectors.toList());
        List<Actor> list3=Stream.concat(list1.stream(),list2.stream()).map(s->{
            String name=s.split(",")[0];
            int age=Integer.parseInt(s.split(",")[1]);
            return new Actor(name,age);
        }).collect(Collectors.toList());
        System.out.println(list3);
    }
}
