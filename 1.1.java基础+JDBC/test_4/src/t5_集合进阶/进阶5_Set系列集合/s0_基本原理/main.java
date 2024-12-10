package t5_集合进阶.进阶5_Set系列集合.s0_基本原理;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Set<String> s1=new HashSet<>();
        s1.add("aaa");
        s1.add("bbb");
        s1.add("ccc");
        //1.迭代器遍历
        Iterator <String>i1=s1.iterator();
        while(i1.hasNext()){
            String temp= i1.next();
            System.out.print(temp+" ");
        }
        System.out.println();
        //2.增强for
        for(String temp:s1){
            System.out.print(temp+" ");
        }
        System.out.println();
        //3.lambda
        s1.forEach((s)->{
            System.out.print(s+" ");
        });

    }
}
