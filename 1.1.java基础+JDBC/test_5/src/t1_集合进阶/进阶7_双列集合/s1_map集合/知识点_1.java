package t1_集合进阶.进阶7_双列集合.s1_map集合;

import java.util.HashMap;
import java.util.Map;

public class 知识点_1 {
    public static void main(String[] args) {
        Map<String,Integer>map=new HashMap<>();
        map.put("明日香",11);
        map.put("战场原",12);
        map.put("赫萝",15);
        int temp=map.put("明日香",18);
        //1.put方法
        // 在添加键值对的过程中，如果键不存在，就直接加入并返回null；如果键存在，就覆盖原先的值并返回
        System.out.println(temp);
        System.out.println(map);
        //2.remove方法
        //返回删除的值
    }
}
