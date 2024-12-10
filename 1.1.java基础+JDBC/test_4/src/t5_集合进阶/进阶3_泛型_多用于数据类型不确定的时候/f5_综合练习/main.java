package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f5_综合练习;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<taidiDog>list=new ArrayList<>();
        ArrayList<boshiCat>list2=new ArrayList<>();
        KeepPet(list);

    }
    public static void KeepPet(ArrayList<?extends Dog> list){

    }
}
