package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f4_泛型的继承和通配符;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<ye>l1=new ArrayList<>();
        ArrayList<zi>l2=new ArrayList<>();
        ArrayList<sun>l3=new ArrayList<>();
        Method(l1);
        Method(l2);
        Method(l3);

    }
    public static void Method(ArrayList<?extends ye> list){

    }
}
class ye{

}
class zi extends ye{

}
class sun extends zi{

}
