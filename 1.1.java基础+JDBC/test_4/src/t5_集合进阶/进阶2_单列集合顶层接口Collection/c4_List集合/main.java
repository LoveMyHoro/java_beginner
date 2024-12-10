package t5_集合进阶.进阶2_单列集合顶层接口Collection.c4_List集合;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        //1.需要注意的是删除元素的时候，举个例子
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //请问：此时删除的是索引1还是元素1？ 答：索引1
        //原因：在调用方法时，如果方法出现了重载现象，则优先调用实参和形参类型一致的那个方法
        //list.remove()接收参数时接收的是包装类型的参数，所以int要手动装箱成integer类型参数
        list.remove(1);
        System.out.println(list);
    }
}
