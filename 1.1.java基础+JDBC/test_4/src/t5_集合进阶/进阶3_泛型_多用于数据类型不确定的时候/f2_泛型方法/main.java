package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f2_泛型方法;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        ListUtil.addAll(list,1,2,3);
        System.out.println(list);

    }
}
