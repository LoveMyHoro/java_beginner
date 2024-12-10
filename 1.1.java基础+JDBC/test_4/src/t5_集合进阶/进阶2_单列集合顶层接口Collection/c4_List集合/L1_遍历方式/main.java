package t5_集合进阶.进阶2_单列集合顶层接口Collection.c4_List集合.L1_遍历方式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class main {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //1.迭代器遍历
        Iterator<String>it=list.iterator();
        while(it.hasNext()){
            String temp=it.next();
            System.out.print(temp+" ");
        }
        System.out.println();
        //2.增强for
        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println();
        //3.Lambda表达式
        list.forEach((s)-> {
            System.out.print(s+" ");
        });
        System.out.println();
        //4.普通for循环
        //5.列表迭代器
        //要了解ListIterator中包含的方法
        //（1）next搭配hasNext使用，previous搭配hasPrevious使用
        //（2）可以用迭代器的方法添加元素
        ListIterator<String>it2=list.listIterator();
        while(it2.hasNext()){
            String temp=it2.next();
            if(temp.equals("bbb")){
                it2.add("qqq");
            }
        }
        System.out.println(list);
    }
}
