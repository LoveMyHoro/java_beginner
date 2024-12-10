package t1_集合进阶.进阶7_双列集合.s1_map集合;

import java.util.HashMap;
import java.util.Map;

public class 知识点_2_3 {
    public static void main(String[] args) {
        //3.lambda表达式遍历
        Map<String,Integer> map=new HashMap<>();
        map.put("明日香",11);
        map.put("战场原",12);
        map.put("赫萝",15);
        //这里的forEach的底层是一个增强for循环
        map.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
}
