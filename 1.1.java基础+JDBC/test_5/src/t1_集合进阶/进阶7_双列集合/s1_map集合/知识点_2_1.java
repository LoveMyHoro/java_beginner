package t1_集合进阶.进阶7_双列集合.s1_map集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 知识点_2_1 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("明日香",11);
        map.put("战场原",12);
        map.put("赫萝",15);
        //1.键找值遍历
        Set<String>set=map.keySet();
        Iterator<String>iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }
    }
}
