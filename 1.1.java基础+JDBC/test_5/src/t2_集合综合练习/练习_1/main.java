package t2_集合综合练习.练习_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"明日香","赫萝","战场原","可可罗");
        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
}
