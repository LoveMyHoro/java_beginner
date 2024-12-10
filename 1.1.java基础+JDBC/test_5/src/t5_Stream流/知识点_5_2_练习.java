package t5_Stream流;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 知识点_5_2_练习 {
    public static void main(String[] args) {
        //collect收集方法
        //1.收集到list集合
        ArrayList <String>list=new ArrayList<>();
        Collections.addAll(list,"明日香-女-15","垃圾君-男-17","赫萝-女-16","可可罗-男-15");
        List<String> newlist=list.stream()
                .filter(s->"女".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(newlist);
        //2.收集到Set集合步骤相同，但会去重且无序

        //3.收集到Map集合时
        //（1）要规定谁是键，谁是值
        //（2）收集到Map集合时，键不能重复
        //（3）Collectors.toMap中的第一个参数是键，第二个参数是值
        Map<String,Integer>map=list.stream()
                .filter(s->"男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s->s.split("-")[0],
                        s->Integer.parseInt(s.split("-")[2])
                ));
        System.out.println(map);


    }
}
