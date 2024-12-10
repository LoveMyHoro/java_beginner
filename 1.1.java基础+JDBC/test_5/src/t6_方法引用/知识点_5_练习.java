package t6_方法引用;

import java.util.ArrayList;
import java.util.Collections;

public class 知识点_5_练习 {
    public static void main(String[] args) {
        ArrayList <String>list=new ArrayList<>();
        Collections.addAll(list,"明日香","战场原","赫萝","杨超越","杨戬");
        //利用方法引用引用其他类（StringOperation）中的方法
        list.stream().filter(new StringOperation()::judge)
                .forEach(s-> System.out.println(s));
    }
}
