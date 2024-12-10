package t4_不可变集合;

import java.util.*;

public class main {
    public static void main(String[] args) {
        //1.在list集合中
        List<String> list=List.of("明日香","赫萝","战场原");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        //尝试修改集合时会报错
        //list.add("111");
        System.out.println("-------------------------------");
        //2.在set集合中
        //注意点：当我们要创建一个不可变的set集合时要保证集合里的元素不重复
        Set<String>mySet=Set.of("明日香","赫萝","战场原");
        Iterator<String>iterator=mySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------");
        //3.在map集合中
        //注意点：
        // （1）键值成对出现
        // （2）上限为20个参数，即10个键值对（因为方法只允许一个可变参数）

        Map<String,Integer>map=Map.of("明日香",11,"赫萝",15,"战场原",16);
        Set<Map.Entry<String,Integer>>entries=map.entrySet();
        for(Map.Entry<String,Integer>entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //（3）可以用可变参数的另一种方法来接收十个以上的方法
        System.out.println("------------------------------");
        HashMap<String,Integer>hm=new HashMap<>();
        hm.put("明日香",11);
        hm.put("赫萝",15);
        hm.put("战场原",17);
        //创建不限长度的不可变Map集合
        Map<String,Integer>map2=Map.copyOf(hm);
        System.out.println(map2);


    }
}
