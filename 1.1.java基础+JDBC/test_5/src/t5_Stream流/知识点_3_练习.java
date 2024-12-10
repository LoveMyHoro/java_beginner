package t5_Stream流;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class 知识点_3_练习 {
    public static void main(String[] args) {
        //1.单列集合的stream流
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"明日香","赫萝","战场原");
        list.stream().forEach(name-> System.out.println(name));
        System.out.println("--------------------------------------");
        //2.双列集合的stream流
        //(1)创建双列集合
        HashMap<String,Integer>hm=new HashMap<>();
        hm.put("明日香",11);
        hm.put("赫萝",12);
        hm.put("战场原",16);
        //第一种获取stream流的方法
        hm.keySet().stream().forEach(key-> System.out.println(key));
        System.out.println("-------------------------------------");
        //第二种获取stream流的方法
        hm.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+" "+entry.getValue()));
        System.out.println("-------------------------------------------");
        //3.数组类型
        //利用Arrays方法获取Stream流
        int []arr={1,2,3,4,5};
        Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
        System.out.println();
        System.out.println("---------------------------------------");
        //4.零散数据
        //要求：需要是同种数据类型
        Stream.of(1,2,3,4,5).forEach(i-> System.out.print(i+" "));
        System.out.println();
        //注意：
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一些零散的数据，也可以传递数组
        //但是数组必须是引用数据类型，如果传递的是基本数据类型，是会把整个数组当成一个元素，放在Stream中

    }
}
