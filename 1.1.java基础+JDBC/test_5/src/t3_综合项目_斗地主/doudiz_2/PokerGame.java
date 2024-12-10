package t3_综合项目_斗地主.doudiz_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    static HashMap<Integer,String>hm=new HashMap<>();
    static ArrayList<Integer>list=new ArrayList<>();

    static{
        int cnt=1;
        String []color={"♥","♠","♦","♣"};
        String []number={"1","2","3","4","5","6","7","8","9","J","Q","k","A"};
        for(String n:number){
            for(String c:color){
                list.add(cnt);
                hm.put(cnt++,c+n);

            }
        }
        list.add(cnt);
        hm.put(cnt,"小王");
        cnt++;
        list.add(cnt);
        hm.put(cnt,"大王");

    }
    public PokerGame(){
        Collections.shuffle(list);
        TreeSet<Integer>lord=new TreeSet<>();
        TreeSet<Integer>Player1=new TreeSet<>();
        TreeSet<Integer>Player2=new TreeSet<>();
        TreeSet<Integer>Player3=new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
            if(i<=2){
                lord.add(list.get(i));
                continue;
            }
            if(i%3==0){
                Player1.add(list.get(i));
            }
            else if(i%3==1){
                Player2.add(list.get(i));
            }
            else{
                Player3.add(list.get(i));
            }
        }
        CheckCard(lord,"底牌");
        CheckCard(Player1,"明日香");
        CheckCard(Player2,"赫萝");
        CheckCard(Player3,"战场原");

    }
    public void CheckCard(TreeSet<Integer> player,String name){
        System.out.print("name"+":");
        for(int temp:player){
            System.out.print(hm.get(temp)+",");
        }
        System.out.println();
    }

}
