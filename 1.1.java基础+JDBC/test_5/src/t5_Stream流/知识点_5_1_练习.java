package t5_Stream流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class 知识点_5_1_练习 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"明日香","战场原","赫萝");

        //1.count方法
        System.out.println(list.stream()
                .count());


        //2.toArray:收集流中的数据并放到数组中
        //（1）空参构造，返回的是object类型
        Object []arr=list.toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------");
        //（2）返回指定类型的数组
        //注意：apply的参数value是流中数据的个数，返回值是具体的数组
        String []arr2=list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr2));
        System.out.println("--------------------------------------");
        //lambda表达式形式
        String []arr3=list.stream().toArray(value->new String[value]);
        System.out.println(Arrays.toString(arr3));
    }
}
