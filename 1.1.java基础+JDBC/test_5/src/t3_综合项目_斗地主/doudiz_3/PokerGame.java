package t3_综合项目_斗地主.doudiz_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    static ArrayList<String>list=new ArrayList<>();
    static HashMap<String,Integer>hm=new HashMap<>();
    static{
        String []color={"♥","♠","♦","♣"};
        String []number={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(String n:number){
            for(String c:color){
                list.add(c+n);

            }
        }
        list.add(" 小王");
        list.add(" 大王");
        hm.put("J",11);
        hm.put("Q",12);
        hm.put("K",13);
        hm.put("A",14);
        hm.put("2",15);
        hm.put("大王",16);
        hm.put("小王",17);


    }
    public PokerGame(){
        Collections.shuffle(list);
        ArrayList<String>lord=new ArrayList<>();
        ArrayList<String>Player1=new ArrayList<>();
        ArrayList<String>Player2=new ArrayList<>();
        ArrayList<String>Player3=new ArrayList<>();
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
        OrderCard(lord,"底牌");
        OrderCard(Player1,"明日香");
        OrderCard(Player2,"赫萝");
        OrderCard(Player3,"战场原");
        checkCard(lord,"底牌");
        checkCard(Player1,"明日香");
        checkCard(Player2,"赫萝");
        checkCard(Player3,"战场原");
    }
    public void OrderCard(ArrayList<String> player,String name){
        Collections.sort(player, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1=o1.substring(0,1);
                String str2=o2.substring(0,1);
                int value1=getValue(o1);
                int value2=getValue(o2);
                int i=value1-value2;
                return i=i==0?str1.compareTo(str2):i;


            }
        });
    }
    public int getValue(String s){
        String str=s.substring(1);
        if(hm.containsKey(str)){
            return hm.get(str);
        }
        else{
            return Integer.parseInt(str);
        }
    }
    public void checkCard(ArrayList<String>list,String name){
        System.out.print(name+":");
        for(String temp:list){
            System.out.print(temp+",");
        }
        System.out.println();

    }
}
