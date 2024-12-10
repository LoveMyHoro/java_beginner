package t2_集合综合练习.练习_3;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<String>list1=new ArrayList<>();
        Collections.addAll(list1,"明日香","赫萝","战场原","vivy","凯尔希");
        Random r=new Random();
        ArrayList<String>list2=new ArrayList<>();
        list2.addAll(list1);
        Collections.shuffle(list2);
        for(int j=0;j<10;j++){
            while(list2.size()!=0){
            int i=r.nextInt(list2.size());
            String name=list2.remove(i);
            System.out.println(name);
        }
            list2.addAll(list1);
            System.out.println("-----------------------------");
        }




    }
}
