package t10_多线程.d9_综合练习.练习_5;

import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);
        Lottery l1=new Lottery(list);
        Lottery l2=new Lottery(list);
        l1.setName("明日香");
        l2.setName("战场原");
        l1.start();
        l2.start();

    }
}
