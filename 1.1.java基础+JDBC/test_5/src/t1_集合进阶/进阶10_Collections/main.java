package t1_集合进阶.进阶10_Collections;

import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        ArrayList <String>list=new ArrayList<>();
        Collections.addAll(list,"aaa","bbb","ccc","dgf");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
