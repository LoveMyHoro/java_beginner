package t5_集合进阶.进阶2_单列集合顶层接口Collection.c2_增强for遍历;

import java.util.ArrayList;
import java.util.Collection;

public class main {
    /*
    1.增强for格式：
    for(数据类型 变量名: 集合/数组){

    }
    变量名代表遍历的集合或数组中的每一个元素（因为这是个for循环）
     */
    public static void main(String[] args) {
        //举个例子
        Collection<String>list=new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        for(String s:list){
            System.out.println(s);
        }
    }
}
