package t2_集合综合练习.练习_2;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<String>ManList=new ArrayList<>();
        Collections.addAll(ManList,"m1","m2","m3","m4","m5","m6");
        ArrayList<String>WoManList=new ArrayList<>();
        Collections.addAll(WoManList,"w1","w2","w3","w4");
        ArrayList<Integer>integers=new ArrayList<>();
        Collections.addAll(integers,1,1,1,1,1,1,1,0,0,0);
        Collections.shuffle(integers);
        Random r=new Random();
        int index=integers.get(r.nextInt(integers.size()));
        System.out.println(index);
        if(index==1){
            System.out.println(ManList.get(r.nextInt(ManList.size())));
        }
        else{
            System.out.println(WoManList.get(r.nextInt(WoManList.size())));
        }


    }
}
