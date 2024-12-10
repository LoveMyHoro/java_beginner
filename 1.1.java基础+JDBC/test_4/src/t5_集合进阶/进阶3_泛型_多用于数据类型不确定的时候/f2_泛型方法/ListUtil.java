package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f2_泛型方法;

import java.util.ArrayList;

public class ListUtil {
    private ListUtil(){

    }
    /*
    由于形参不确定，所以要加上<E>
     */
    //这里e是可变参数，相当于数组
    public static <E> void  addAll(ArrayList<E> list,E ...e){
        for(E temp:e){
            list.add(temp);
        }
    }
    public void Show(){
        System.out.println("Holo");
    }

}
