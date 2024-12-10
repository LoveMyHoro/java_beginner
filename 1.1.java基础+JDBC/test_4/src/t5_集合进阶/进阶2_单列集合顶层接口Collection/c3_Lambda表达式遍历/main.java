package t5_集合进阶.进阶2_单列集合顶层接口Collection.c3_Lambda表达式遍历;

import java.util.ArrayList;
import java.util.Collection;

public class main {
    public static void main(String[] args) {
        //1.底层原理：ForEach在内部也会自己遍历集合，依次得到每一个元素，
        //然后把得到的每一个元素，传递给下面得accept函数，s依次表达集合中的每一个数据
        Collection<String> list=new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.forEach((s)->{
            System.out.println(s);
        });

    }
}
