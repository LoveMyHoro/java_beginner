package t1_集合进阶.进阶7_双列集合.s4_TreeMap.练习_1;

import java.util.Comparator;
import java.util.TreeMap;

public class main_1 {
    public static void main(String[] args) {
        TreeMap<Integer,String>treeMap=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        treeMap.put(4,"优乐美");
        treeMap.put(2,"可乐");
        treeMap.put(1,"薯片");
        treeMap.put(3,"雪碧");
        System.out.println(treeMap);
    }
}
