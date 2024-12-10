package t6_方法引用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 知识点_8_训练 {
    public static void main(String[] args) {
        //将集合数据收集到数组中
        ArrayList <Integer>list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        Integer []arr=list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));


    }
}
