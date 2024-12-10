package t5_Stream流.s1_练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 练习_1 {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
        List<Integer> arr=list.stream()
                .filter(i->i%2==0)
                .collect(Collectors.toList());
        System.out.println(arr);
    }
}
