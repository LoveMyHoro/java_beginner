package t6_方法引用;

import java.util.ArrayList;
import java.util.Collections;

public class 知识点_4_练习 {
    public static void main(String[] args) {
        //要求：把字符集合转换为字符串
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        //方法1:利用Stream流
        list.stream().map(s->{
            return Integer.parseInt(s);
                }
        ).forEach(i->{
            System.out.print(i+1+" ");
        });
        System.out.println( );
        //方法2:利用方法引用
        list.stream()
                .map(Integer::parseInt)
                .forEach(s-> System.out.print(s+2+" "));
        System.out.println();


    }
}
