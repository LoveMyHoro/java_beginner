package t1_集合进阶.进阶7_双列集合.s1_map集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 知识点_2_2 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("明日香",11);
        map.put("战场原",12);
        map.put("赫萝",15);
        //2.键值对遍历
        //(1)通过一个方法返回一个set集合，里面包含所有的键值对对象
        //(2)Entry是map的内部接口，需要Map.来引用
        Set<Map.Entry<String,Integer>>set=map.entrySet();
        set.forEach((Map.Entry<String,Integer>entry)->{
            System.out.println(entry.getKey()+" "+entry.getValue());
        });


    }
}
